String[] shellcom = {"xterm"};
        Process p ;
        //builder.directory(new File(path));        // not here.
        builder = new ProcessBuilder(shellcom);                
        builder.directory(new File(path));          // here.
        p = builder.start();