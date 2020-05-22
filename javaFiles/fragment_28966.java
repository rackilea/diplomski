String singleLine;
String wholeText = "";
try {
    while((singleLine = bf.readLine()) != null) {
        wholeText += singleLine;
    }
} catch(IOException x) {
}