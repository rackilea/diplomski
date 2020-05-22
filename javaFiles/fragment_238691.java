Scanner scanner = new Scanner(new File(fullPath + ".dec"));
String content = null;
try {
   content = scanner.useDelimiter("\\Z").next();
} finally {
   scanner.close();
}