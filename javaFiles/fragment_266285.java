while (true) {
    def line = readLineFromFile()
    if (line==null) {
        break
    }
    closure(line, count++)
}