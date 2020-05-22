List<String> SomeStringListArray = new ArrayList<String>();
BufferedReader in = new BufferedReader(new FileReader(new File(fileName)));
String s;
while ((s = in.readLine()) != null) {
    SomeStringListArray.add(s);
}
in.close();