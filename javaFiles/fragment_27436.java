File f = new File("C:\\"); // current directory

    ArrayList<String> sequence = new ArrayList<>();
    sequence.add("TATA");
    sequence.add("TOTO");

    FilenameFilter filter = new FilenameFilter() {
        public boolean accept(File dir, String name) {
            String lowercaseName = name.toLowerCase();
            if (lowercaseName.endsWith(".xml"))
                return true;
            else
                return false;
        }
    };

    String[] totoFiles = f.list(filter);
    Arrays.sort(totoFiles, Collections.reverseOrder());
    for (String type : sequence) {
        int i = 0;
        for (; i < totoFiles.length; i++) {
            if (totoFiles[i].contains(type))
                break;
        }
        System.out.println(totoFiles[i]);
    }