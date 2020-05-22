String latin1 = "class Latin1 {\n"
        + " public static void main(String[] args) {\n"
        + "        String s = \"µ\";\n"
        + "        System.out.println(s);\n"
        + " }\n"
        + "}";
Files.write(Paths.get("Latin1.java"), 
        latin1.getBytes(StandardCharsets.ISO_8859_1));

String utf8 = "class Utf8 {\n"
        + " public static void main(String[] args) {\n"
        + "        String s = \"µ\";\n"
        + "        System.out.println(s);\n"
        + " }\n"
        + "}";
Files.write(Paths.get("Utf8.java"), 
        latin1.getBytes(StandardCharsets.UTF_8));
}