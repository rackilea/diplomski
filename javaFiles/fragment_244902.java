File srcFolder = new File("./src");
String[] files = srcFolder.list();
for(String file : files){
    if(file.startsWith("My_App_")){
        System.out.println(file);
    }
}