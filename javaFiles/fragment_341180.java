fun bytestoUUID(buf: ByteArray, offset: Int): UUID {
    var lsb: Long = 0
    for (i in 15 downTo 8) {
        lsb = lsb shl 8 or (buf[i + offset].toLong() and 0xff)
    }

    var msb: Long = 0
    for (i in 7 downTo 0) {
        msb = msb shl 8 or (buf[i + offset].toLong() and 0xff)
    }

    return UUID(msb, lsb)
}