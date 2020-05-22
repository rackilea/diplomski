if (!checkPrivileges()) {
        try {
            String jarPath = DownloaderMain.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            String decodedPath = URLDecoder.decode(jarPath, "UTF-8");
            decodedPath = decodedPath.substring(1, decodedPath.length());
            Elevator.executeAsAdministrator(System.getProperty("java.home") + "\\bin\\java", "-jar " + "\"" + decodedPath + "\"");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    } else {
        // Run with elevated privileges
    }