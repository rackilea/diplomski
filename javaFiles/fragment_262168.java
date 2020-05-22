//Gets from the current working directory a path to B/C/D
Path path = Paths.get("B/C/D");
//String equal to "B/C/D"
path.toString();
//String equal to "/home/myprojects/project1/src/B/C/D"
path.toAbsolutePath().toString();