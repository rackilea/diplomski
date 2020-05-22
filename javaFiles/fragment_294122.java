try {
    MatrixWriter.loadDataStore(dataStore);
}
catch(IOException e) {
    System.out.print("File does not exist or is corrupted, exiting with Status 1");
    e.printStackTrace();
    System.exit(1);
}