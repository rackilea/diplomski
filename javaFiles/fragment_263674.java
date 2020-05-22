try {
    br = new BufferedReader(new FileReader("src/files/names.csv"));
} catch (FileNotFoundException e) {
    e.printStackTrace();
    System.exit(0);
}