String[] inputs = {
        "GRAYSCALE=(120)",// -- Expected output: True
        "GRAYSCALE=(120);",// -- Expected output: True
        "GRAYSCALE=(120);abcd",// -- Expected output: True
        "GRAYSCALE=(120)abcd",// -- Expected output: False
        "abGRAYSCALE=(120)",// -- Expected output: False
        "abc;GRAYSCALE=(120);acx" // --> Expected output: true
};

Pattern p = Pattern.compile("(.*?)\\b;?GRAYSCALE=\\(([0-9]{1,2}|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\)(?:;\\w*)?$");
for (String input: inputs) {
    Matcher m = p.matcher(input);
    System.out.printf("%s found? %b%n", input, m.find());
}