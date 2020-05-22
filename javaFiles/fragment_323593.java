class Split {
    public static void main (String[] args) {
        String inputString = "if (com.google.code) then";
        Pattern p=Pattern.compile("((?<=\\()[^}]*(?=\\)))"); // Find text within parenthesis
        Pattern p2 = Pattern.compile("(\\w+)(\\))"); // Find last portion of text between . and )

        Matcher m = p.matcher(inputString);
        Matcher m2 = p2.matcher(inputString);
        String in2 = "";
        if (m2.find())
            in2=m2.group(1); // else ... error checking
        inputString = m.replaceAll(in2); // do whatcha need to do
    }
}