ProcessBuilder builder = new ProcessBuilder(command);
Process process = builder.start();

BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
StreamReader outputReader = new StreamReader(process.getInputStream(), System.out);
outputReader.start();
StreamReader err = new StreamReader(process.getErrorStream(), System.err);
err.start();

for (int i = 0; i < 3; i++) {
    Thread.sleep(5000);
    writer.write(internalProcessCommand + "\n");
    writer.flush();
}
writer.write("exit\n");
writer.flush();

while (process.isAlive()) {
    System.out.println("alive?");
    Thread.sleep(100);
}
System.out.println("dead");
outputReader.shutdown();
err.shutdown();