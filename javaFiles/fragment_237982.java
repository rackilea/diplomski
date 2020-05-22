Process process = null;
    try {
        ProcessBuilder builder = new ProcessBuilder("D:\\Demo\\pvaroptimizer\\bin\\pvaroptimizer.exe", "-p", importantInfo[0], "D:\\Demo\\pvaroptimizer\\bin\\New structure.pvz");

        builder.redirectErrorStream(true);
        process = builder.start();

        InputStream stream = process.getInputStream();
        while(stream.read()!=-1){}
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }