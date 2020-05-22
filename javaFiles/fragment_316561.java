public static List<Person> load(String filename) throws IOException {
 FileInputStream fis = new FileInputStream(filename);
 ObjectInputStream ois = new ObjectInputStream(fis);
 List<Person> list = (List<Person>) ois.readObject();
 ois.close();
 return list;
}