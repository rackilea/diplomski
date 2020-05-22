public class Main {

public static void main(String args[]) throws IOException {

    List<String> foldersPath = new ArrayList<String>();
    File folderPathFile = new File("C:\\Users\\ankur\\Desktop\\folderPath.txt");

    /**
     * Read the folderPath.txt and get all the path and store it into
     * foldersPath List
     */
    BufferedReader reader = new BufferedReader(new FileReader(folderPathFile));
    String line = reader.readLine();
    while(line != null){
        foldersPath.add(line);
        line = reader.readLine();
    }
    reader.close();

    /**
     * Map the path(i.e Folder) to the total no of 
     * files present in that path (i.e Folder)
     */
    Map<String, Integer> noOfFilesInFolder = new HashMap<String, Integer>();
    for (String pathOfFolder:foldersPath){
        File[] files2 = new File(pathOfFolder).listFiles();//get the arrays of files
        int totalfilesCount = files2.length;//get total no of files present
        noOfFilesInFolder.put(pathOfFolder,totalfilesCount);
    }

    System.out.println(noOfFilesInFolder);
}

}