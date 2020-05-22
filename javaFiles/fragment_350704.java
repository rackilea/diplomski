public class IncreaseCounter {

    static final SimpleDateFormat FILE_DATE = new SimpleDateFormat("MMM_dd_yyyy");

    public static void main(String[] args) {

        // filter files which matches the given pattern
        FilenameFilter fileNameFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.matches("^name_..._.._.....*\\.txt");
            }
        };

        // needed to sort the file list based on the file counter
        Comparator<File> sortByCounter = new Comparator<File>() {
            @Override
            public int compare(File file1, File file2) {
                return getFileCounter(file1.getName()) - getFileCounter(file2.getName());
            }
        };

        String filesLocation = "resources/";
        int highestCounter = 0;

        // read the files matching the filter
        File[] listFiles = new File(filesLocation).listFiles(fileNameFilter);
        List<File> files = Arrays.asList(listFiles);

        // sort the files by their file counter
        Collections.sort(files, sortByCounter);

        // get the highest counter
        String fileWithHighestCounter = files.get(files.size() - 1).getName();
        highestCounter = getFileCounter(fileWithHighestCounter);

        String nextFileName = String.format("name_%s_%d.txt",
                FILE_DATE.format(new Date()), 
                highestCounter + 1
        );

        System.out.println("nextFileName = " + nextFileName);
    }

    /**
     * Extract the file counter.
     * @param fileName the file name
     * @return 0 - if the file has no counter, otherwise the counter value
     */
    static int getFileCounter(String fileName) {
        String namePatternWithCounter = "^name_..._.._...._*(.*)\\.txt";
        String counterString = fileName.replaceAll(namePatternWithCounter, "$1");
        if (counterString.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(counterString);
    }
}