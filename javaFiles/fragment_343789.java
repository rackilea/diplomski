File file = new File("help","file.pdf");   //'file.pdf' file in 'help' folder 
String classpath = System.getProperty("java.class.path");
StringTokenizer tokenizer = new StringTokenizer(classpath,";");
while(tokenizer.hasMoreTokens()){
    File temp = new File(tokenizer.nextToken(), file);
    if(temp.exists()){
        // here you get your file as 'temp'.
        // If you want it to be in URL form, you can convert it.
        break;
    }
}