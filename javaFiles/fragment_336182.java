public static void main(String[] args){
    File[] files = new File("temp").listFiles();
    showFiles(files);
}

public static void showFiles(File[] files) {
    for (File file : files) {
        if (file.isDirectory()) {
            System.out.println("Directory: " + file.getName());
            showFiles(file.listFiles()); 
        } else {
            System.out.println("File: " + file.getName());
            getFileNameAndSuffix(file);
        }
    }
}
public static void getFileNameAndSuffix(File file) 
{
    int index = file.getName().lastIndexOf('.');
    System.out.println(file.getName().substring(0, index));
    System.out.println(file.getName().substring(index));
}