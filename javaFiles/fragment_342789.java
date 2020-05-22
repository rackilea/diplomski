while((entry = zis.getNextEntry()) != null) {
    System.out.println("Extracting: " + entry);
    int count;
    byte[] data = new byte[BUFFER];
    String filename = entry.getName();
    System.out.println("Filename: " + filename);
    while ((count = zis.read(data, 0, BUFFER)) != -1) {
       // Do whatever you want with the data variable
       System.out.println(data);
    }
}