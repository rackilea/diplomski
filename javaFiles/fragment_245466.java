String t = "th/is i/s a /test \\/t";
String r1 = "/";
String r2 = "\\/";
String[] t1 = t.split(r1);
for (int i = 0; i < t1.length; i++) {
    System.out.println(t1[i]);
}