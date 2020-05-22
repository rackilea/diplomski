ProcessBuilder builder = new ProcessBuilder("cmd");
Process p = builder.start();
BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(p.getOutputStream));
for(int i=0;i<7;i++) {
    writer.write("dir"); 
    writer.newLine(); 
    writer.flush();
}
// Now terminate
writer.write("exit"); 
writer.newLine(); 
writer.flush();
p.waitFor();