File file = new File(packageName.replace(".", "/"));
for(File file1 : file.listFiles()){
    if(file1.getName().trim().substring(file1.getName().trim().lastIndexOf("."),
       file1.getName().trim().length()).equalsIgnoreCase(".xml")){
       configuration.addResource( packageName.replaceAll("\\.", "/") + "/" + file1.getName() );
    }
}