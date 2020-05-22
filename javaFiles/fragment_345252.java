InputStream in = this.getClass().getResourceAsStream(resource);
        BufferedReader rdr = new BufferedReader(new InputStreamReader(in));
        String line;
        while ((line = rdr.readLine()) != null) {
            this.copyResourceIntoTempFile(resource+"/"+line, new File(dir, line));
        }
        rdr.close();