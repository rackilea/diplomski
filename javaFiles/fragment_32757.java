String downloadDir = "..\\webapps\\demoproject\\files";

    String currentdir = System.getProperty("user.dir");
    String programFiles = System.getenv("ProgramFiles");

    String filePath = "";
    if(programFiles.equals("C:\\Program Files"))
    {
        filePath = currentdir + "\\" + downloadDir + "\\demo.pdf";
    }
    else
    {
        filePath = currentdir + "\\" + "bin"+ "\\" + downloadDir + "demo.pdf";
    }

    File pdfFile = new File(filePath);
    String absolutePath = pdfFile.getAbsolutePath();
    System.out.println(absolutePath);