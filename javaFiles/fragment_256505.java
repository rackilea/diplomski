static String PATH = "Workbench/SUTD/ISTD_50.570/assignments/data/train";

// the global list of all words across all articles
static Set<String> GLOBO_DICT = new HashSet<String>();

public static void main(String[] args) throws IOException {
    // each of the diferent categories
    String[] categories = { "/atheism", "/politics", "/science", "/sports" };
    File trainpath = new File(System.getProperty("user.home"), PATH);
    // cycle through all categories once to populate the global dict
    for (String cycle : categories) {
        File directory = new File(trainpath, cycle);
        iterateDirectory(directory);
    }
}