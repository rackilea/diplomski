public static Set<Student> getListOfStudents() throws IOException, ClassNotFoundException {
    File studentFile = new File("Student.dat");
    FileInputStream in = null;
    try {
        in = new FileInputStream(studentFile);
        ObjectInputStream oos = new ObjectInputStream(in);
        retyurn (Set<Student>) oos.readObject();
    } catch(FileNotFoundException noStudents) {
        return new HashSet<Student>();
    } finally {
        if (in != null)
           try {
               in.close();
           } catch(IOException ignored) {}
    }
}