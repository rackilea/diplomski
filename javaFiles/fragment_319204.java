PrintWriter out = new PrintWriter(new FileWriter(tem));
        //System.out.println(""+filePath);
        while ((line = br.readLine()) != null) {
            out.println(line);
        }
        out.close();
        temp.setReadOnly();
        String[] cmd = {"notepad",tem}; 
        Runtime runtime = Runtime.getRuntime();
        Process proc = runtime.exec(cmd);
        // proc.getInputStream();