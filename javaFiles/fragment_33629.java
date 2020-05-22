String text = t.getText(p);
String lines[] = text.split("\\r?\\n"); // give you all the lines separated by new line

String cols[] = lines[0].split("\\s+") // gives array separated by whitespaces
// cols[0] contains pins
// clos[1] contains TENSIONE[V]
// cols[2] contains TOLLRENZA if not present then its empty