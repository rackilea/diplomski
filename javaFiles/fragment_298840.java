File source = new File("C:\\Users\\cc\\eclipse-workspace\\data\\file.xml");
    String srcEncoding="ISO-8859-1";
    File target = new File("C:\\Users\\cc\\eclipse-workspace\\data\\file2.xml");
    String tgtEncoding="UTF-8";
      try (
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(source), srcEncoding));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(target), tgtEncoding)); ) {
            char[] buffer = new char[16384];
            int read;
            while ((read = br.read(buffer)) != -1)
                bw.write(buffer, 0, read);

  }