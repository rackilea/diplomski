fun readUpToNull(inputStream: InputStream): String {
    return buildString {
        while (true) {
            val ch = inputStream.read().toChar()
            if (ch == '\u0000') break
            append(ch)
        }
    }
}