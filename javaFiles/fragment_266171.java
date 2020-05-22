Process proc = Runtime.getRuntime().exec("java -jar C:\\...\\Run1.jar 1");
        proc.waitFor();

        //2 inputstream for the result and for the errors in subprogram     
        InputStream in = proc.getInputStream();
        InputStream err = proc.getErrorStream();

        byte b[]=new byte[in.available()];
        in.read(b,0,b.length);
        System.out.println(new String(b));

        byte c[]=new byte[err.available()];
        err.read(c,0,c.length);
        System.out.println(new String(c));

        ProcessBuilder pb = new ProcessBuilder("java", "-jar", "C:\\...\\Run1.jar", "1");
        Process proc2 = pb.start();
        proc2.waitFor();

        InputStream in2 = proc2.getInputStream();
        InputStream err2 = proc2.getErrorStream();

        byte b2[]=new byte[in.available()];
        in.read(b,0,b.length);
        System.out.println(new String(b));

        byte c2[]=new byte[err.available()];
        err.read(c,0,c.length);
        System.out.println(new String(c));