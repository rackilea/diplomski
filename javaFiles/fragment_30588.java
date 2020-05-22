FileReader fr = new FileReader("Keys.txt");
BufferedReader br = new BufferedReader(fr);
String str="", l="";
while((l=br.readLine())!=null) { //read lines until EOF
    str += " " + l;
}
br.close();
System.out.println(str); // str would be like " Text 1 Text 2 Text 3"
String[] array = str.trim().split(" "); //splits by whitespace, omiting 
// the first one (trimming it) to not have an empty string member