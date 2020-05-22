ProcessBuilder builder = new ProcessBuilder(
            "cmd.exe", "/c", "cd D:/CVS_REPO/ && dir && cvs checkout  && cd project_folder && cvs commit -m \"Admin Tool\"");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) { break; }
            System.out.println(line);
        }