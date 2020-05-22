FileInputStream fileInputStream = new FileInputStream("TEXT.txt");
InputStreamReader inputStreamReader = new InputStreamReader(
        fileInputStream, "UTF-8");
BufferedReader bf = new BufferedReader(inputStreamReader);
words.add("<s>");
String s;
while ((s = bf.readLine()) != null) {
    s = s.replaceAll("[^a-zA-Z ]", ""); // replace all non-word/non-space characters with an empty string
    String[] var = s.split(" ");
    words.addAll(var);
}