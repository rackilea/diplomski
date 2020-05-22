BufferedReader r = new BufferedReader(new FileReader(myFile));
String s = r.readLine();
while (s != null) {
    // do something with s
    s = r.readLine();
}
r.close();