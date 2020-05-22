for (int i = 0; i<n; i++) {
    String someData = "data for the files";
    FileOutputStrem fos = new FileOutputStrem(ROOT_DIR + "familyname" + n + "_parts.txt");
    fos.write(someData);
    fos.close();
}