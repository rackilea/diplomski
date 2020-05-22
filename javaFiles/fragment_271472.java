if(!fileChecker.exists()) {
    try {
        fileChecker.createNewFile();
    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Unable to create new File");
    }
}