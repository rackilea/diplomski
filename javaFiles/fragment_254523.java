private static final String ROOT_FOLDER_DEFAULT = "C:/work";
private static final String[] EXTENSIONS = {".doc", ".docm", ".xls"};
// TODO: the keywords are not used anywhere yet
private static final String[] KEYWORDS = {"Performance Enhancement", "Functional Specification", "Technical Specification", "Faults", "Arval", "Vehicle", "Fines", "Insurance"};

public void start(String rootFolder) {       
    List<String> files = new ArrayList<>();
    readFilesRecursively(new File(rootFolder), files);
    // trick to print list contents by converting to array
    System.out.println(Arrays.toString(files.toArray()));
}        

// recursion is not that common so when you use it, 
// it's a good idea to clearly indicate this in the method name
public void readFilesRecursively(File folder, List<String> files) {
    for (File file : folder.listFiles()) {
        if (file.isDirectory()) {
            readFilesRecursively(file, files);
        } else {
            for(String extension : EXTENSIONS) {
                String fileName = file.getName();
                if (fileName.contains(extension ) && !isTemporaryFile(fileName)) {
                    files.add(fileName);
                }
            }
        }
    }
}

// if you find yourself adding a comment in the middle of your code
// that usually means you need to extract a method for that bit
private boolean isTemporaryFile(String fileName) {
    return fileName.startsWith("~$");
}

public static void main(String[] args) throws Exception {    
    KeywordsRecognition app = new KeywordsRecognition();
    app.start(getRootFolder(args));
}

private static String getRootFolder(String[] args) {
    if(args != null && args.length > 0) {
        return args[0];
    }
     else {
        return ROOT_FOLDER_DEFAULT:
    }
}