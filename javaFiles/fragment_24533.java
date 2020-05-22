File f = new File("path_to_directory");
String[] list = f.list();
String keeper = "";

for(String s: list){
    if(s.contains("blah")){
       keeper = s;
    }
}