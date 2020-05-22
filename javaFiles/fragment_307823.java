File dir = new File("c:/dir");

if (!dir.isDirectory()) {
    dir.mkdirs();
}
long dirLength = dir.length();
System.out.println(dirLength);