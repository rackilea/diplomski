String string = "mumbai(10)";
Pattern p = Pattern.compile("^.*\\((\\d+)\\)$");
Matcher m = p.matcher(string);
if (m.matches()) {
    System.out.println(m.group(1));
}