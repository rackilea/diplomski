String data = "(in1 == 1'b1) |(in == 1'b1) | !out & (sig==1'b0) | !1out2 & (sig==1'b0)";
// I will try to split on every special character and space
String[] allTokens = data.split("[=()&|!\\s]+");
// but this will produce
// [, in1, 1'b1, in, 1'b1, out, sig, 1'b0, 1out2, sig, 1'b0]

// so I will try to filter tokens that are not only digits and letters
// with at least one letter
List<String> correctTokens = new ArrayList<>();

Pattern p = Pattern.compile("(?=.*[a-zA-Z])[a-zA-Z0-9]");
//(?=.*[a-zA-Z]) will return true if data will contain at least one letter
//and will contain only letters a-zA-Z and digits 0-9
for (String s : allTokens) {
    Matcher m = p.matcher(s);
    if (m.matches()) {
        correctTokens.add(s);
    }
}
System.out.println(correctTokens);