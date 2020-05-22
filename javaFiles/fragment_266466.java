String sample="abc\ninterface\nsomedata\nxxx\n!\nsdfff\ninterface\nyyy\n!\n";
Pattern pattern = Pattern.compile("(?s)(?<=\\ninterface\\n).*?(?=\\n!\\n)");//Pattern.compile("(?m)^.*$");
Matcher m =pattern.matcher(sample);
while (m.find()) {
    System.out.println(m.group());
}