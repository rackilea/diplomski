FileInputStream fis = new FileInputStream(new File("/home/.../testInput.txt") );
    InputStreamReader isr = new InputStreamReader( fis, Charset.forName("UTF-16LE") );
    BufferedReader br = new BufferedReader( isr );
    FileOutputStream fos = new FileOutputStream(new File("/home/.../testOutput.txt"));
    OutputStreamWriter osw = new OutputStreamWriter( fos, Charset.forName("UTF-8") );
    BufferedWriter bw = new BufferedWriter( osw );
    String line = null;
    while ( (line = br.readLine()) != null ) {
        bw.write(line);
        bw.newLine();   // will add an unnecessary newline at the end of your file, fix this
    }
    bw.flush();
    // take care of closing the streams here etc.