try {
        InputStream iss = getClass().getResourceAsStream("/folder/SMSCApplication.pdf"); //update the filename here when the help guide is written
        byte[] data = IOUtils.toByteArray(iss);
        iss.read(data);
        iss.close();
        String tempFile = "User_Guide";
        File temp = File.createTempFile(tempFile, ".pdf");
        FileOutputStream fos = new FileOutputStream(temp);
        fos.write(data);
        fos.flush();
        fos.close();
        logger.error(temp.getAbsolutePath());
        Desktop.getDesktop().open(temp.getAbsoluteFile());
    } catch (IOException ex) {
        logger.error(ex);

    }