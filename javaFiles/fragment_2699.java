// field separator
String separator = ";";

//...
int i = 0;

Map<String, int> headers = new HashMap<>();

for (String line : lines) {
    if (i == 0) {
        String[] headLine = line.split(separator);
        for (int j = 0; j < headLine.length; j++) {
            headLine.put(headLine[j], j);
        }
        i++;
        continue;
    }
}