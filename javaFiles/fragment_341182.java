final int lineSeparatorLength = System.getProperty("line.separator").getBytes().length;

// 9 = line length in bytes without separator
final int lineLength = 9 + lineSeparatorLength;

try (final RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
    // Position the cursor at the beginning of the first line to swap
    raf.seek(lineLength);

    // Read the first line to swap
    final byte[] firstLine = new byte[lineLength];
    raf.read(firstLine);

    // Position the cursor at the beginning of the second line
    raf.seek(lineLength * 2);

    // Read second line
    final byte[] secondLine = new byte[lineLength];
    raf.read(secondLine);

    // Move the cursor back to the first line
    // and override with the second line
    raf.seek(lineLength);
    raf.write(secondLine);

    // Move the cursor to the second line
    // and override with the first
    raf.seek(lineLength * 2);
    raf.write(firstLine);
}