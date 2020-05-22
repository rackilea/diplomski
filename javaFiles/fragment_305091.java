public class FileSearch {

    private List<String> result;

    public List<String> getResult() {
        if (result == null) {
            result = new ArrayList<String>();
        }
        return result;
    }

    public static void main(String[] args) {
        FileSearch fileSearch = new FileSearch();
        fileSearch.search(new File("C:/Users"), "rashed.txt");
        int count = fileSearch.getResult().size();
        if (count == 0) {
            System.out.println("\nNo result found!");
        } else {
            System.out.println("\nFound " + count + " result!\n");
            for (String matched : fileSearch.getResult()) {
                System.out.println("Found : " + matched);
            }
        }
    }

    public void search(File file, String filename) {
        if (file.isDirectory()) {
            System.out.println("Searching directory ... " + file.getAbsoluteFile());
            //do you have permission to read this directory?
            if (file.canRead()) {
                if (file.listFiles() != null) {
                    for (File temp : file.listFiles()) {
                        if (temp.isDirectory()) {
                            search(temp, filename);
                        } else {
                            if (filename.equalsIgnoreCase(temp.getName())) {
                                getResult().add(temp.getAbsoluteFile().toString());
                            }
                        }
                    }
                }
            } else {
                System.out.println(file.getAbsoluteFile() + "Permission Denied");
            }
        }
    }
}