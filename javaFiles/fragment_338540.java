ArrayList<String[]> numstrsList = new ArrayList<String[]>();
    if (returnVal == JFileChooser.APPROVE_OPTION) {
        File importedFile = fc.getSelectedFile();

        try {
            Scanner sc = new Scanner(importedFile);
            while (sc.hasNextLine()) {
                numstrsList.add(sc.nextLine().split("\\s+")); // split by white
                                                        // space
            }
        } catch (IOException e) {

        }
}