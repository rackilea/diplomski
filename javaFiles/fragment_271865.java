for (int i = 0; i < fileNames.length; i++) { 
        System.out.println("Reading from " + fileNames[i]); 

        File f = new File(dir, fileNames[i]);

        BufferedReader br = new BufferedReader(new FileReader(f));

        String line = br.readLine();
        if (i > 0) 
              line = br.readLine(); //just skip the first line

        while (line != null) {
            pw.println(line); 
            line = br.readLine(); 
        } 

        pw.flush(); 
    }