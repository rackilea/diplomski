public void write(String args) {
    try {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file.getAbsoluteFile(), true));
        writer.write(args);
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}