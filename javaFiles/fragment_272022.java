Scanner s = new Scanner(new File("SHA1.txt"));
try {
    String sha1Txt = s.useDelimiter("\\Z").next();
    ...
    return result;
}
finally {
    s.close();
}