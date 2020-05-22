Path currentPath = Paths.get("C:\\projects\\project1");
String pathFromUser = "..\\project2";

Path userPath = Paths.get(pathFromUser);

if (userPath.isAbsolute()){
    currentPath = userPath;
}else{//is relative
    currentPath = currentPath.resolve(userPath).normalize();
}

System.out.println(currentPath);