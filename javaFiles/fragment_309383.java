String Extraction="cmd.exe /c start C:\\task\\Extracting.bat "; 
//Runtime.getRuntime().exec(Extraction);

final Process p = new ProcessBuilder("cmd.exe", "/c", "start /WAIT C:\\task\\Extracting.bat").redirectErrorStream(true).start();
p.waitFor();
System.out.println("Job done!!");