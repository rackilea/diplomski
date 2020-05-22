private static void codeWrap() {
    int position;
    for(String keyword: javaKeywords) {

        if((position = findInString(builder.toString(), keyword)) != -1) {
            builder.insert(position, "[code]");
            builder.insert(position + keyword.length()+6, "[/code]");
       }

    }
}