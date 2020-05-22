String s = "1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15";
Pattern pat = Pattern.compile("(?:\\d+, *){4}\\d+");
Matcher mat = pat.matcher(s);
StringBuilder output = new StringBuilder();
while(mat.find()) {
    output.append(mat.group()).append("\n");
}
System.out.print(output);