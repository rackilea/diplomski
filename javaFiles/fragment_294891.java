public static void main(String args[]) {
    String fileName = args[0];
    Scanner s = null;

    try {
        s = new Scanner(new BufferedReader(new FileReader(fileName));

        while (s.hasNext()) {
            System.out.println(s.next());
        }
    } finally {
        if (s != null) {
            s.close();
        }
    }
}