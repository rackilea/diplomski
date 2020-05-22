Process proc = new ProcessBuilder(appStr).start();
proc.getInputStream().close();

InputStream eos = proc.getErrorStream();
BufferedReader reader = new BufferedReader(new InputStreamReader(eos));
for ( String line = null; (line = reader.readLine()) != null; ) {
   System.err.println(line);
}

System.out.println(proc.waitFor());