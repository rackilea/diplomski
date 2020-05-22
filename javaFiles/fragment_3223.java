// some code where you can get exception

Writer fileWriter = new FileWriter(new File(<path to directory>));
String str = "some string or null if error occurs";
dBufferedWriter.write(str);     
dBufferedWriter.close();