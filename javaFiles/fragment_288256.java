try {
    File file=new File("/data/data/com.holomedia.holomedia/files/config.txt");

    if (file.exists()) {
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder text = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            if (!line.equals(g) && !g.equals("\n")){
                text.append(line);
                text.append('\n');
            }
        }
        br.close();

        //start writing from here
        FileOutputStream fos = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos);
        outputStreamWriter.write(text.toString());
        outputStreamWriter.flush();
        outputStreamWriter.close();
    } 
} catch (IOException e) {
    Log.e("Exception", "File write failed: " + e.toString());
}