public class Test {

    public static void main(String[] args) {
        try {
            String root = "C:\\Users\\owner\\Desktop\\Screen Shot\\";
            List<File> files = getFileList(new File(root));
            for(File file : files ){
                System.out.println(file);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static List<File> getFileList(File filePath)
            throws FileNotFoundException{

        List<File> fileList = new ArrayList<File>();
        File[] files = filePath.listFiles();
        List<File> fileandFolderList = Arrays.asList(files);
        for (File file : fileandFolderList) {
            fileList.add(file);
            if (file.isDirectory()) {
                List<File> innerFileList = getFileList(file);
                fileList.addAll(innerFileList);
            }
        }

        return fileList;
    }
}