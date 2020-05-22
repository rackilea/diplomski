private static String reformat(String og){
    String reformattable = og;
    String[] parts = reformattable.split("\\[",2);
    String arrayPart = parts[1];
    String arrayOnly = arrayPart.split("]",2)[0];
    reformattable = arrayOnly.replaceAll("\\{\n","{");
    reformattable = reformattable.replaceAll("\",\n", "\\\",");
    reformattable = reformattable.replaceAll(" +"," ");
    reformattable = reformattable.replaceAll("\\{ ","   {");
    reformattable = reformattable.replaceAll("\n }","}");

    return og.replace(arrayOnly,reformattable);
}