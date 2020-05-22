String text = "[timestamp1] INFO - Message1 \r\n"
            + "[timestamp2] ERROR - Message2 \r\n"
            + "[timestamp3] INFO - Message3 \r\n"
            + "Message3_details1......... \r\n"
            + "Message3_details2 ......... \r\n";

String regex = "\\[(.*?)\\] (.*?) - (.*?)(?=\\[|$)";

Pattern p = Pattern.compile(regex, Pattern.DOTALL);
Matcher m = p.matcher(text);
while (m.find()) {
    System.out.println("G1: " + m.group(1));
    System.out.println("G2: " + m.group(2));
    System.out.println("G3: " + m.group(3));
    System.out.println();
}