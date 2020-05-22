public Driver(String cfgFile) {
    this.cfgFilePath = cfgFile;
    this.keys = getKeys(cfgFilePath);
    this.a1 = keys.get(0);
    this.b1 = keys.get(1);
}

private ArrayList<String> keys = new ArrayList<>();
private String a1;
private String b1;