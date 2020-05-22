try {
    ...
} 
catch (FileNotFoundException e) {
    // handle subclass
}
catch (IOException e) {
    // handle general exception (this will not be executed if the
    // exception is actually a FileNotFoundException
}