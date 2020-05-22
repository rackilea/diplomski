try {
        Runtime r = Runtime.getRuntime();                    
        Process p = r.exec("/actualdirforscript/scripts/ls.pl");
        BufferedReader in =
            new BufferedReader(new InputStreamReader(p.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
              out.print(inputLine);
        } 
        in.close();
    } catch (IOException e) {
        System.out.println(e);
    }