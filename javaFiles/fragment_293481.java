Runtime rt = Runtime.getRuntime();
    Process pr;
    File myFolder = new File("C:\\Temp");
    pr = rt.exec(new File(myFolder, "myExec.bat").getAbsolutePath(), null, myFolder);
    pr.waitFor();
    pr.destroy();