public static void save(String filename, List<Person> list) throws IOException {
 FileOutputStream fos = new FileOutputStream(filename);
 ObjectOutputStream oos = new ObjectOutputStream(fos);
 oos.writeObject(list);
 oos.close();
}