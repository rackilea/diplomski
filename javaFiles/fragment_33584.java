String test = "En la fase de maquetación de un documento o una página web o para probar un tipo de letra es necesario visualizar el aspecto del diseño. ٩(-̮̮̃-̃)۶ ٩(●̮̮̃•̃)۶ ٩(͡๏̯͡๏)۶ ٩(-̮̮̃•̃).";

    for (String chunk : cutString(test, 24, "UTF-8")) {
        System.out.println(String.format(
                "Chunk [%s] - Chars: %d - Bytes: %d",
                chunk, chunk.length(), chunk.getBytes("UTF-8").length));
    }
    /*
    Prints:
        Chunk [En la fase de maquetaci] - Chars: 23 - Bytes: 23
        Chunk [ón de un documento o un] - Chars: 23 - Bytes: 24
        Chunk [a página web o para pro] - Chars: 23 - Bytes: 24
        Chunk [bar un tipo de letra es ] - Chars: 24 - Bytes: 24
        Chunk [necesario visualizar el ] - Chars: 24 - Bytes: 24
        Chunk [aspecto del diseño. ٩(] - Chars: 22 - Bytes: 24
        Chunk [-̮̮̃-̃)۶ ٩(●̮̮] - Chars: 14 - Bytes: 24
        Chunk [̃•̃)۶ ٩(͡๏̯͡] - Chars: 12 - Bytes: 23
        Chunk [๏)۶ ٩(-̮̮̃•̃).] - Chars: 14 - Bytes: 24
     */