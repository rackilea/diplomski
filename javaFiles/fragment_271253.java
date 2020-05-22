String[] lines = input.split("\n\r?|\r");
int nLines = lines.length;
String[][] fields = new String[nLines][];
for (int i = 0; i < nLines; ++i) {
  fields[i] = lines[i].trim().split("[ \t]+");
}