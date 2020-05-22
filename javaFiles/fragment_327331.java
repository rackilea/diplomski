String test = "%fila%\nVal1,val2,val3\n%/fila%";

Pattern bracket = Pattern.compile("%([^%]+)%([^%]*)%/\\1%", Pattern.MULTILINE);
Matcher m = bracket.matcher(test);
if (m.find()) {
    String middle = m.group(2);
    String tagged = "<tr>"+
        middle
        .replaceAll("[^,\n]+", "<th>$0</th>")
        .replaceAll(",","\n")
    +"</tr>";
    System.out.println(tagged);
}