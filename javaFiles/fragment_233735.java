public void fillVal(String fileName) {
    try {
        Scanner kb = new Scanner(new File(fileName));
        while(kb.hasNextDouble()) {
           // code
        }
    } catch(FileNotFoundException e) {
        System.out.println("Invalid filename!");
        e.printStackTrace();
    }
}