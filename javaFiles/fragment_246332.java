String s = "00 44 88 45 00 25 78 46 00 46 58 00";
Pattern pattern = Pattern.compile("^(?:00(?:\\s+00)*\\s+)?(\\d{2})|(\\d{2})(?:\\s+00(?:\\s+00)*)?$");
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    if (matcher.group(1) != null) {
        System.out.println(matcher.group(1)); 
    }
    if (matcher.group(2) != null)  {
        System.out.println(matcher.group(2));
    }
}