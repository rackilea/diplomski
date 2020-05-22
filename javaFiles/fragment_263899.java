ProcessBuilder pbuilder = new ProcessBuilder("bash", "-c", <<your command as string>>);
        File err = new File("err.txt");
        try {
            pbuilder.redirectError(err);
            Process p = pbuilder.start();
            p.waitFor();      

        } catch (Exception e) 
        {
             //handle exceptions if any.
        }