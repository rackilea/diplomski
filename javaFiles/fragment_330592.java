public ResultFormat runBatch(String fileName) {

String var = fileName;
String filePath = ("C:/Users/attsuap1/Desktop/" + var+".bat");
try {
    Process p = Runtime.getRuntime().exec(filePath);