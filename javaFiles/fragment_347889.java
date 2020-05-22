public class Folder {
    public static HashMap<String, ArrayList<String>> dirFiles = new HashMap<String, ArrayList<String>>();

    public static void listFilesForFolder(File folder)
            throws IOException {

        if(folder.isDirectory()) {

            ArrayList<String> fileNames = new ArrayList<String>();

            for (final File fileEntry : folder.listFiles()) {
               // System.out.println(fileEntry.toString());
                if (fileEntry.isDirectory()) {
                //  System.out.println(fileEntry.toString());
                    listFilesForFolder(fileEntry);
                } else {
                    String fileName = (fileEntry.getPath()).toString();
                    fileNames.add(fileEntry.getPath());
                }
            }
            dirFiles.put(folder.getName(), fileNames);
        }
    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        listFilesForFolder(new File("C:/Users/Guest/Documents/MainFolder"));
        for(Entry<String, ArrayList<String>> foldername : dirFiles.entrySet())
        {
            System.out.println(foldername.getKey() + " " + foldername.getValue());
        }
    }

}