System.out.println("\r\nChose desired shelf:");
String shelf = br.readLine();
FileReader fr = new 
FileReader("D:\\admir\\MyBookLibrary\\"+shelf+"\\Info.txt");
BufferedReader info = new BufferedReader(fr);
String line;
while((line = info.readLine()) != null) {
    System.out.println(line);
}
fr.close();
info.close();