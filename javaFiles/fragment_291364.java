List<MyFolder> myFolder = new ArrayList<MyFolder>();
File file = new File("D:/test");
MyFolder childArray = new MyFolder();
readFiles(file,myFolder,childArray);

Gson json = new Gson();
System.out.println(json.toJson(myFolder));