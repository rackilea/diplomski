String string = "0123456789ABCDEF";
    StringBuilder bigAssString = new StringBuilder(1024*1024*3);
    for (int i = 0; i < ((1024*1024*3)/16); i++) {
        bigAssString.append(string);
    }
    System.out.println("bigAssString.length = " + bigAssString.toString().length());
    bigAssString.replace((1024*1024*3)/4, ((1024*1024*3)/4)+1, "á");

    for (String chunk : cutString(bigAssString.toString(), 1024*1024, "UTF-8")) {
        System.out.println(String.format(
                "Chunk [...] - Chars: %d - Bytes: %d",
                chunk.length(), chunk.getBytes("UTF-8").length));
    }
    /*
    Prints:
        bigAssString.length = 3145728
        Chunk [...] - Chars: 1048575 - Bytes: 1048576
        Chunk [...] - Chars: 1048576 - Bytes: 1048576
        Chunk [...] - Chars: 1048576 - Bytes: 1048576
        Chunk [...] - Chars: 1 - Bytes: 1
     */