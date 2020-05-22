class StudentFactory {

    private static List<Student> listCache = new ArrayList<>();

    static List<Student> getStudents(final String filePath) {
        if (listCache.isEmpty() {
            BufferedReader in = null;
            try {
                in = new BufferedReader(new FileReader(filePath));
                String line;
                while((line = in.readLine()) != null) {
                    // Parse the line and create a Student instance from it, then add it to the list
                    listCache.add(student);
                }
            } catch(IOException e) {
                System.err.println("Exception, man");
                e.printStackTrace();
            } catch(FileNotFoundException e) {
                System.err.println("File wasnt found ");
                e.printStackTrace();
            } finally {
                if (in != null) in.close();
            }
        }
        return listCache;
    }

    private StudentFactory() {
        // Avoid instantiation
    }
}