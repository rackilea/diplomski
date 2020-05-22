public static void save(String filename, List<Person> list) throws IOException {
 PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
 for (Person person : list) {
    pw.println(person.toString());
   }
 pw.close();
}