try {
    File file = new File(fileName);
}
catch (FileNotFoundException e) {
    e.printStackTrace();
}
Scanner inStream = new Scanner(file);