public static void main(String[] args) {

// replace here by your directory path
File dir = new File("directory_path");

String prefixe = "Rz";
String sufixe = "ls";

// retrieve all the file with name containing Rz at the beginning and ends with ls
File[] files = dir.listFiles(fileName -> 
                  fileName.getName().startsWith(prefixe) && 
                  fileName.getName().endsWith(sufixe));

// if you need to have all the name of the file without prefixe/sufixe
List<String> list = Stream.of(files)
                          .map(file -> 
                               file.getName().substring(prefixe.length(), 
                                                        file.getName().length() - sufixe.length()))
                          .collect(Collectors.toList());
}