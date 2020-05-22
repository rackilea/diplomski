try {
    FileOutputStream fos = new FileOutputStream(myExternalFile);
    fos.write(yourValuesAsString.getBytes()); // Convert any values you want to store into strings before writing to files
    fos.close();
} catch (IOException e) {
    e.printStackTrace();
}