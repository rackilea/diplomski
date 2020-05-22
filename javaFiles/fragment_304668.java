try {
    doSomething();
}
catch (FileNotFoundException e) {
    System.out.println("File not found!");
}
catch (IOException e) {
    System.out.println("An I/O error has occurred: " + e.getMessage());
}