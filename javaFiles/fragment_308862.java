public String getMergedFiles(File datFolder) {
    ArrayList<File> files = new ArrayList<>();
    files.addAll(Arrays.asList(datFolder.listFiles((f) -> f.getName().endsWith(".dat") && f.getName().startsWith("UW110"))));

    StringBuilder sb = new StringBuilder();

    for (File datFile : files) {
        InputStream is = new FileInputStream(datFile);
        BufferedReader buf = new BufferedReader(new InputStreamReader(is));

        String line = buf.readLine();
        while(line != null) {
            sb.append(line).append("\n");
            line = buf.readLine();
        }

        buf.close();
        is.close();
    }

    return sb.toString();
}

public void writeToFile(String input, File file) {
    PrintWriter out = new PrintWriter(file);
    try{
        out.println(input);
    }catch(Exception e){
        e.printStackTrace();
    }
    out.close();
}

// Somewhere in your code
File folder = new File("myFolder");
writeToFile(getMergedFiles(folder), new File("outputFile.dat"));