// Note leading forward slash:
File file = new File("/ME/Development Folder/Short_Closed/abc.pdf") ;
File workingDir = file.getParentFile();
String filename = file.getName();

String[] cmd = new String[] {"open", "-R", filename} ;
Runtime.getRuntime().exec(cmd, null, workingDir);