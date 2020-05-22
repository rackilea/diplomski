File f = new File("my.txt");
FileReader fr = new FileReader(f);
BufferedReader br  = new BufferedReader(fr);

String s = null;

while ((br=readLine())!=null) {

// Do whatever u want to do with the content of the file,eg print it on console using SysOut...etc

}

br.close();