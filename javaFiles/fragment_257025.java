String quote = "I say: \"I have something to say, \"It's better to burn out then fade away\"\" outloud...";

if (quote.contains("\"")) {

    while (quote.contains("\"")) {
        int startIndex = quote.indexOf("\"");
        int endIndex = quote.lastIndexOf("\"");
        quote = quote.substring(startIndex + 1, endIndex);
        System.out.println(quote);
    }

}