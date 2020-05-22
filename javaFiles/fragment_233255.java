String pathedfilename = "d:/temp/my.properties";
    try {
        FileReader rdr = new FileReader(pathedfilename);
        FileWriter writer = new FileWriter(pathedfilename);
        Properties props = new Properties();
        props.load(rdr);
        props.setProperty("key1", "myval");
        props.store(writer, "saved");
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }