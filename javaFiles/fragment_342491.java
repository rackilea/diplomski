Scanner fs = null;
try {
    ...
    fs = new Scanner(new FileReader(file));
}
catch (FileNotFoundException fe) {
    ...
}
finally {
    return fs;
}