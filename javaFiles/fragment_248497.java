// note no leading forward slash
String file = "ME/Development Folder/Short_Closed/abc.pdf"
File workingDir = new File("/");
String[] cmd = new String[]{"open", "-R", file};

Runtime.getRuntime().exec(cmd, null, workingDir);