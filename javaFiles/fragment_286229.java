String execPath = "resources\\pict.exe";
String inPath = "resources\\CarOrderApp.txt";
String outPath = "resources\\CarOrderApp.xls";

ProcessBuilder builder = new ProcessBuilder(execPath, inPath);
builder.redirectOutput(new File(outPath));
Process p = builder.start();
p.waitFor();