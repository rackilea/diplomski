File dir = new File("Mydirectory"); 
Path dataPath = Paths.get("tableData.csv"); 
SStringBuilder strb = new StringBuilder();
strb.append("bcp ");
strb.append("\"select " + column + "  from " + credentials.getSchema() + ".dbo." + table_name + "\" ");
strb.append("queryout ");
strb.append(dataPath.toString());
strb.append(" -c ");
strb.append("-t ");
strb.append(", ");
strb.append("-S ");
strb.append(credentials.getServer());
strb.append(" -U ");
strb.append(credentials.getUser());
strb.append(" -P ");
strb.append(credentials.getPassword());

File shellFile = new File(folderName + File.separator + "exec.sh");

try (FileOutputStream outShell = new FileOutputStream(shellFile)) {
    outShell.write(strb.toString().getBytes());
    outShell.flush();
}
shellFile.setExecutable(true, false);
shellFile.setWritable(true, false);
shellFile.setReadable(true, false);
builder = new ProcessBuilder(shellFile.getAbsolutePath());

File logFile = new File("LogFile.txt");
System.out.println("BCP command :" + builder.command());
builder.redirectlogFile(logFile); builder.directory(dir); 
Process exec = builder.start();
System.out.println("BCP process completed : with errors :" + exec.waitFor());
System.out.println("BCP logFile :" + org.​apache.​commons.​io.FileUtils.readFileToString(logFile));