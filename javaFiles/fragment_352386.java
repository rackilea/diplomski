public static void main(String[] args) throws ParseException {
    final String[] in = {"Head northwest on Lincoln St toward Warbuton Ave 0.1 mi",
        "Head northwest on Middlefield Rd toward Embarcadero Rd 95 ft",
        "Make a U-turn at Warbuton Ave 0.3 mi",
        "Take the first right onto Embarcadero Rd 12.43 mi"};
    final Pattern pattern = Pattern.compile("[0-9]++(?:\\.[0-9]++)?(?=\\s++(?:mi|ft))", Pattern.CASE_INSENSITIVE);
    for (final String s : in) {
        final Matcher m = pattern.matcher(s);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}