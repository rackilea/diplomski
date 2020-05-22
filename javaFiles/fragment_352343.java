public void readFile() {

    // B
    // list = new ArrayList<InClass>();

    try {
        File file = new File("test.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = reader.readLine()) != null) {
            // Here is where assignToObject() was //

            // B
            // list = new ArrayList<InClass>();

            InClass n = new InClass(line);
            list.add(n);
            System.out.println(list.size());
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    readObject();
}