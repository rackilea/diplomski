Properties config = new Properties();
try {
    config.load(<this.class>.getResourceAsStream(<property-file-name>)); //example input stream
    //now can access it as a Map instance
    config.get(<Key>);
    config.entrySet();

    //additionally, you can access Properties methods
    config.getProperty(<property-name>);

} catch(...) {
    ...
}