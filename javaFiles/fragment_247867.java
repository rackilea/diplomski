java.util.Vector key = new Vector<String>() //could be Object

key.add("myCo");
key.add("user@myCo.com");
key.add("2012");
key.add("04");
key.add("1");

vw.getAllDocumentsByKey(key, false);