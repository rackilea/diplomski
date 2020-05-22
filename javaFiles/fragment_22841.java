String[] words = text.split("(?=[\\s\\.])");
ArrayList<String> array = new ArrayList<String>();
int i = 0;
while (words.length > i) {
    String line = "";
    while ( words.length > i && line.length() + words[i].length() < 100 ) {
        line += words[i];
        i++;
    }
    array.add(line);
}