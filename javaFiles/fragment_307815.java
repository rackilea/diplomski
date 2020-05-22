private static synchronized void uploadUsingSFTP(
            Map<String, String> ftpPrameterList) {
        new SFTPUtility().uploadFileMFT(ftpPrameterList.get("sFTPUser"),
                ftpPrameterList.get("sFTPHost"), new Integer(ftpPrameterList
                        .get("sFTPPort")), ftpPrameterList.get("sFTPPwd"),
                ftpPrameterList.get("sourceLocation"), ftpPrameterList
                        .get("destinationLocation"), ftpPrameterList
                        .get("uploadedFileName"));
    }