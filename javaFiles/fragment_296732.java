Scanner x = new Scanner(System.in);
String pattern = "^(249)?1\\d{8}$";
Pattern r = Pattern.compile(pattern);
while (true) {
    String line = x.nextLine();
    Matcher m = r.matcher(line);
    if (m.find()) {
         System.out.println("Found -> " + m.group());
    } else {
         System.out.println("Not Found");
    }
}