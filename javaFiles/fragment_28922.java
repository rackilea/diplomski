File directory = new File(System.getProperty("user.home") + "/AppData/Roaming" + "/Folder WithMyJar");
directory.mkdir();
Process p = Runtime.getRuntime().exec("java -jar " + directory.getPath() + "\\" + "myJar.jar arg1 arg2");
InputStream inError = process.getErrorStream();
BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inError));
System.out.println("Error=" + bufferedReader.readLine());