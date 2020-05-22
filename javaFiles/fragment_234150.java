final String code = "/**\n" + 
                    " * \n" + 
                    " * @param args\n" + 
                    " */\n" +
                    "public static void main(final String[] args) { }\n";
final String codeWithoutComments = Pattern.compile("\\/\\*.*?\\*\\/", Pattern.DOTALL).matcher(code)
        .replaceAll("");
System.out.println(code);
System.out.println(codeWithoutComments);