private void save(String _url){
    Properties prop = new Properties();
    prop.setProperty("url", _url);
    prop.store(new FileOutputStream("file.properties"), null);
}

private String open(){
    Properties prop = new Properties();
    prop.load(new FileInputStream("file.properties"));
    return prop.getProperty("url");
}