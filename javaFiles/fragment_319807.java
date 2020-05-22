String[] titles = new String[data.length/2];
String[] isbnS = new String[data.length/2];
int count = 0;
for (int i = 0; i < data.length; i += 2) {
    titles[count] = data[i];
    isbnS[count] = data[i + 1];
    count++;
}