ProcessBuilder processBuilder = new ProcessBuilder(
        "mysqldump", "-u", "root", "-P", "3316", "-h", "localhost");
processBuilder.redirectErrorStream(true);
processBuilder.redirectOutput(new File("G:\\test.sql"));
Process process = processBuilder.start();
int resultCode = process.waitFor();
if (resultCode != 0) {
    throw new Exception("Program failed with error " + resultCode);
}