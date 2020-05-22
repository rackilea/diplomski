try(FileInputStream fis = new FileInputStream(fileChecker); ObjectInputStream ois = new ObjectInputStream(fis)) {
    // ...
}
catch (FileNotFoundException exc) {
    // no such file ...
}
// other catch blocks as before.