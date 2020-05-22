String sourceFolder = new File("C:\\test\\robocopytest\\source\\20170925T213857460").toString();
        String destFolder = new File("C:\\test\\robocopytest\\destination\\20170925T213857460").toString();
        StringBuffer rbCmd = new StringBuffer();
        if ((sourceFolder != null) && (destFolder != null))
        {
          if (sourceFolder.contains(" ")) {
            if (sourceFolder.startsWith("\\")) {
              sourceFolder = "/\"" + sourceFolder.substring(1) + "/\"";
            } else {
              sourceFolder = "\"" + sourceFolder + "\"";
            }
          }
          if (destFolder.contains(" ")) {
            if (destFolder.startsWith("\\")) {
              destFolder = "/\"" + destFolder.substring(1) + "/\"";
            } else {
              destFolder = "\"" + destFolder + "\"";
            }
          }
          rbCmd.append("robocopy " + sourceFolder + " " + destFolder);
          Process p = Runtime.getRuntime().exec(rbCmd.toString());
        }