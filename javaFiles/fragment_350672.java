//ensure content in file is updated
outfile.flush();

BufferedReader br = null;
try {
    br = new BufferedReader(new FileReader(outfile));
    String line;
    while ((line = br.readLine()) != null) {
         System.out.println(line);
    }
}
catch (IOException e) {
    e.printStackTrace();
}
finally {
    try {
        br.close();
    }
    catch (IOException e) {
        e.printStackTrace();
    }
}