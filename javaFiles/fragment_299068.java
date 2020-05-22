public class FileConverter {

public static void main(String[] args) throws IOException {
    FileConverter converter = new FileConverter();
    File newFile1 = new File("c:/parent1/file1.dump");
    File newFile2 = new File("c:/parent2/file2.dump");
    converter.convert2Files(newFile1, newFile2);
}

private void convert2Files(File file1, File file2) throws IOException {
    // compare if the 2 files have the same name
    if(file1.getName().equalsIgnoreCase(file2.getName())){
        String newName = file1.getName().substring(0, file1.getName().lastIndexOf('.')); 
        String newNameOriginal = newName + ".txt";
        String newNameStep2 = newName + ".Step2.txt";
        File newFileOriginal = new File(file1.getParent(),newNameOriginal);
        File newFileStep2 = new File(file1.getParent(),newNameStep2);
        Path file = file1.toPath();/* use file1 as source file */
        Path to = Paths.get(file1.getParent());/* path to destination directory */
        Files.copy(file, to.resolve(newFileOriginal.toPath()));
        Files.copy(file, to.resolve(newFileStep2.toPath()));
    }
}
}