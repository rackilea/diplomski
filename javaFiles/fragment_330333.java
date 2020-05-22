String str = "&&";
String rx = "(&&.*\\|{2}|\\|{2}.*&&)|(\\|{2})|(&&)";
Pattern ptrn = Pattern.compile(rx);
Matcher m = ptrn.matcher(str);
if (m.find()) {
    if (m.group(1) != null)
        System.out.println("The string has double pipe and ampersands!");
    else if (m.group(2) != null)
        System.out.println("The string has double pipes!");
    else if (m.group(3) != null)
        System.out.println("The string has double ampersands!");
}