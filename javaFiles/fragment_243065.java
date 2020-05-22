public static void main(String args[]) {
File folder = new File("C:\\userids-20130501");
File[] listOfFiles = folder.listFiles();

Set<String> userIdSet = new LinkedHashSet<String>();
for (int i = 0; i < listOfFiles.length; i++) {
    File file = listOfFiles[i];
    if (file.isFile() && file.getName().endsWith(".txt")) {
        try {
            List<String> content = FileUtils.readLines(file, Charset.forName("UTF-8"));
            userIdSet.addAll(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 }