try {

    readNamesFiles();

} catch (IOException exp) {

    this.firstNames = new String[] { "John" };
    this.lastNames = new String[] { "Doe" };

}