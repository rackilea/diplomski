OUTER:while((line = reader.readLine()) != null) {
String[] temp = line.split(" ", 2);  //this splits the tag from the rest of the line, which are pairs of (x,y)
m = p.matcher(temp[1]);
INNER:while(m.find()) {
    x = Double.parseDouble(m.group(1));
    y = Double.parseDouble(m.group(2));

    if(x > 100 || y > 100) {
        matches.add(temp[0]);
        break INNER; // ***this breaks the loop named INNER
    }
}