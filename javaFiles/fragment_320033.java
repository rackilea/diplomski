FileInputStream in = new FileInputStream("First.properties");
Properties props = new Properties();
props.load(in);
in.close();

FileOutputStream out = new FileOutputStream("First.properties");
props.setProperty("country", "america");
props.store(out, null);
out.close();