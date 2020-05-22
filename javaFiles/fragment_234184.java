# Write properties to private storage:
FileOutputStream fos = context.openFileOutput(cfg, Context.MODE_PRIVATE);
Properties props = new Properties();
props.setProperty("lanecount", "10001000");
props.setProperty("time", "12:00");
prop.store(fos, "This is a comment"); // store() is threadsafe
fos.close();

... ...

# Read properties from private storage: 
FileInputStream fis = context.openFileInput(cfg);
Properties props = new Properties();
props.load(fis); // load() is threadsafe
fis.close();
String lanecount = props.getProperty("lanecount");
String time = props.getProperty("time");