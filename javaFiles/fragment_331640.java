Properties props = new Properties();
props.load(in); // create input stream for your file.
// from now you have Properties object with your data.
// since properties extends Hashtable the task is done.
// if you still need keys in list, say
List<Object> keys = new ArrayList<Object>(props.keySet());