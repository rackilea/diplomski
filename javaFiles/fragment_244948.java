try {
    File folder = new File("/temp/temp");
    folder.mkdirs();
    // then create a file object at this location
    File file = new File(folder, contador + ".txt");

    escritor = new FileWriter(file);
    // the rest of your code
}
catch (Exception e) {
}