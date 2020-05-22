private val BUFFER_SIZE = 8192

@Throws(IOException::class)
private fun copy(source: InputStream, sink: OutputStream, networkStatistics: NetworkStatistics, measureSpeed : (NetworkStatistics) -> Unit = { }): Long {
    var nread = 0L
    val buf = ByteArray(BUFFER_SIZE)
    var n: Int
    n = source.read(buf)
    while (n > 0) {
        val nano = measureNanoTime {
            sink.write(buf, 0, n)
            nread += n.toLong()
            n = source.read(buf)
        }
        networkStatistics.amountSent = nread
        networkStatistics.lastPacketBytes = n.toLong()
        networkStatistics.lastPacketTime = nano
        measureSpeed(networkStatistics)
    }
    return nread
}

@Throws(IOException::class)
fun copy(`in`: InputStream, target: Path, networkStatistics: NetworkStatistics, measureSpeed : (NetworkStatistics) -> Unit = { }, vararg options: CopyOption ): Long {
    // ensure not null before opening file
    Objects.requireNonNull(`in`)

    // check for REPLACE_EXISTING
    var replaceExisting = false
    for (opt in options) {
        if (opt === StandardCopyOption.REPLACE_EXISTING) {
            replaceExisting = true
        } else {
            if (opt == null) {
                throw NullPointerException("options contains 'null'")
            } else {
                throw UnsupportedOperationException(opt.toString() + " not supported")
            }
        }
    }

    // attempt to delete an existing file
    var se: SecurityException? = null
    if (replaceExisting) {
        try {
            Files.deleteIfExists(target)
        } catch (x: SecurityException) {
            se = x
        }

    }

    // attempt to create target file. If it fails with
    // FileAlreadyExistsException then it may be because the security
    // manager prevented us from deleting the file, in which case we just
    // throw the SecurityException.
    val ostream: OutputStream
    try {
        ostream = Files.newOutputStream(target, StandardOpenOption.CREATE_NEW,
                StandardOpenOption.WRITE)
    } catch (x: FileAlreadyExistsException) {
        if (se != null)
            throw se
        // someone else won the race and created the file
        throw x
    }

    // do the copy
    ostream.use { out -> return copy(`in`, out, networkStatistics, measureSpeed = { networkStatistics -> measureSpeed(networkStatistics) }) }
}