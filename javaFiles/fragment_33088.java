ProcessBuilder pb = new ProcessBuilder("java", "-jar", "myfile.jar", "arg1");
pb.redirectErrorStream(true);

Process p = pb.start();

InputStream in = p.getInputStream();
InputStreamReader ins = new InputStreamReader(in);
BufferedWriter out = new BufferedWriter(new OutputStreamWriter(p.getOutputStream());
BufferedReader br = new BufferedReader(ins);

String line = null;

while ((line = br.readLine()) != null) {
    System.out.println(line);

    if (line.contains("Start the load process (y/n)?")) {
        out.write("y");
        out.newLine();
        out.flush();
    }

    if (line.contains("Start the patch process (y/n)?")) {
        out.write("n");
        out.newLine();
        out.flush();
    }
}

out.close();
p.waitFor();
p.destroy();