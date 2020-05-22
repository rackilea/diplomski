String quote = "I say: \"I have something to say, \"It's better to burn out then fade away\"\" outloud...\"Just in case you don't believe me\"";

String[] split = quote.split("\"");
for (String value : split) {
    System.out.println(value);
}