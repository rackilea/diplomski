File f = new File(".");

File[] files = f.listFiles();

DateFormat df = new SimpleDateFormat("MMM dd HH:mm:ss");

// for each name in the path array
for (File file : files) {

    System.out.printf("%4d %s %s%n", file.length(), df.format(file.lastModified()), file.getName());

}