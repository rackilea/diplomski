public static void main(String[] args) throws FileNotFoundException {
    ArrayList<ArrayList<String>> biD = new ArrayList<ArrayList<String>>();
    file = new Scanner(new File("C:/tmp/text.txt"));
    //ArrayList<String> line = new ArrayList<String>(); <-- Move down to 

    while (file.hasNextLine()) {

        ArrayList<String> line = new ArrayList<String>(); <-- Down here      
        final String nextLine = file.nextLine();
        final String[] items = nextLine.split(",");

        for (int i = 0; i < items.length; i++) {
            line.add(items[i]);
        }

        biD.add(line);
        rows++;
        Arrays.fill(items, null); // to clear out the 'items' array
    }...