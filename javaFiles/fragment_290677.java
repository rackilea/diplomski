String ALPHA = "\p{Alpha}";
String NUMERIC = "\d";

String test1 = "a1";
String test2 = "aa22";

ArrayList<String> alpha = new ArrayList();
ArrayList<String> numeric = new ArrayList();

alpha.add(test1.split(ALPHA));
numeric.add(test1.split(NUMERIC));
alpha.add(test2.split(ALPHA));
numeric.add(test2.split(NUMERIC));