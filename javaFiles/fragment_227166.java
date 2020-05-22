FileInputStream fin = null;
    try {
        fin = new FileInputStream(pdfDoc);
        byte fileContent[] = new byte[(int) pdfDoc.length()];
        fin.read(fileContent);
    } catch (IOException | FileNotFoundException e) {
        System.out.println("");
        e.printStackTrace();
    }