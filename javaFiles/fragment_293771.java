List<String> lst = new ArrayList<>();
String s = "NEUE BÜHNE Senftenberg, Theaterpassage 1, 01968 Senftenberg";
Pattern pattern = Pattern.compile("([^0-9]+?)\\s*([0-9]+)[\\W_]+([0-9]{5})\\s*(.*)");
Matcher matcher = pattern.matcher(s);
if (matcher.matches()){
    lst.add(matcher.group(1));
    lst.add(matcher.group(2));
    lst.add(matcher.group(3));
    lst.add(matcher.group(4));
} 
System.out.println(lst); // => [NEUE BÜHNE Senftenberg, Theaterpassage, 1, 01968, Senftenberg]