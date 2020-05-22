String[] inputs = {
        "Coord=(1,1)",// -- Expected output: True
        "Coord=(1,1);",// -- Expected output: True
        "Coord=(1,1):",// -- Expected output: False
        "Coord=(1,1)abc",// -- Expected output: False
        "Coord=(1,1);abc"// -- Expected output: True
};
//                                              | this is the important bit
Pattern p = Pattern.compile("Coord=\\(\\d,\\d\\)(;|$)");
for (String input: inputs) {
    Matcher m = p.matcher(input);
    System.out.printf("%s found? %b%n", input, m.find());
}