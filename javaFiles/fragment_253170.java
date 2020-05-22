String wkhtmltopdf_path = "/usr/local/bin/wkhtmltopdf";
    String paperSize = "A4";
    String url = "https://www.google.com/";

    // This is where your output file is/was defined, now with error handling
    File outputFile = null; 
    try {
        //file in which you want to save your pdf
        outputFile = File.createTempFile("sample", ".pdf");
        System.out.println(outputFile.getAbsolutePath()); // Show output file path, remove this in production
    } catch (IOException e1) {
        e1.printStackTrace();
    }

    // This is where your process runs, with error handling
    Process process = null;
    try {
        process = Runtime.getRuntime().exec(String.format("%s -s %s %s %s", wkhtmltopdf_path, paperSize, url, outputFile.getAbsolutePath()));
    } catch (IOException e) {
        e.printStackTrace(); // Do your error handling here
    }

    // This is where your exitStatus and waitFor() was/is, with error handling
    int exitStatus = 0;
    try {
        //do a wait here to prevent it running for ever
        exitStatus = process.waitFor();
    } catch (InterruptedException e) {
        e.printStackTrace(); // Do your error handling here
    }
    if (exitStatus != 0) {
        // Do error handling here
    }