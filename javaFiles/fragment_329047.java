public static void convert1252toUFT8(String fileName) throws IOException {
    Path in = Paths.get(fileName), out = Paths.get(fileName+"x");
    int readCount = 0, writeCount = 0;
    try(Reader br = Channels.newReader(Files.newByteChannel(in), "windows-1252");
        Writer bw = Channels.newWriter(
            Files.newByteChannel(out, WRITE, CREATE, TRUNCATE_EXISTING),
            StandardCharsets.UTF_8)) {

        char[] buffer = new char[1000];
        do {
            int count = br.read(buffer);
            if(count < 0) break;
            readCount += count;

            // if you really want to replace non breaking spaces:
            for(int ix = 0; ix < count; ix++) {
                if(buffer[ix] == 160) buffer[ix] = ' ';
            }

            bw.write(buffer, 0, count);
            writeCount += count;
        } while(true);
    } finally {
        System.out.println("Chars read in="+readCount+" Chars written out="+writeCount);
    }
}