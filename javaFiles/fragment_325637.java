InputStream is = this.getClass().getResourceAsStream("hello.sh");

String[] cmd = null;
File tempFile = null;

tempFile = File.createTempFile("hello", "sh");
// extract the embedded hello.sh file from the war and save it to above file
OutputStream os = new FileOutputStream(tempFile);
byte[] buffer = new byte[1024];
int bytes;
while( (bytes = is.read(buffer)) != -1) {
    os.write(buffer, 0, bytes);
}
os.close();      

tempFile.setExecutable(true);

cmd = new String[] { tempFile.getAbsolutePath() };

Runtime runtime = Runtime.getRuntime();
Process process = runtime.exec(cmd);