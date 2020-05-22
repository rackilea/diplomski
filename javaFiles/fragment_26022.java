String pattern = "\\d{3}:\\d{2}(?:,\\d{3}:\\d{2})*";
Pattern r = Pattern.compile(pattern);
Matcher m = r.matcher("111:11,222:22,222:22");

while (m.find()) {
       System.out.println(m.group());   
}