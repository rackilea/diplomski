static public void findCyclicDependency2() {
    PrintWriter outFile = null;

    Map<String,File> fileNames = new HashMap<String,File>();
    Map<String,Set<String>> fileBackward = new HashMap<String,Set<String>>();
    Map<String,Set<String>> fileForward = new HashMap<String,Set<String>>();

    try {
        File baseInputDirectory = new File(strInputPath);

        List<File> baseInputDirListing = getFileListing(baseInputDirectory);

        // Printing out the filenames for the SodaSystem
        for(File swPackage:baseInputDirListing) {

            if (! (swPackage.isDirectory()
                    || swPackage.getName().endsWith("Plus"))) continue;

            System.out.println("Loading file names");
            List<File> currSwPackageFileListing = getFileListing(swPackage);
            for(File dependentFile:currSwPackageFileListing) {
                String name = trimName(dependentFile);
                fileNames.put(name,dependentFile);

                BufferedReader br = new BufferedReader(new FileReader(dependentFile));
                String line;
                Set<String> contFor = new HashSet<String>();
                Set<String> contBack = new HashSet<String>();
                while( (line=br.readLine()) != null ) {
                    line = line.toUpperCase().trim();
                    if( line.equals("EXTRA") ) continue;
                    if( line.equals("INDICES") ) continue;
                    if( line.equals(name) ) continue;

                    if( line.compareTo(name) == 1 ) {
                        contFor.add(line);
                    } else {
                        contBack.add(line);
                    }
                }
                fileBackward.put(name,contBack);
                fileForward.put(name,contFor);
            }

            String strCyclicDependencyOut = strOutputPath + "_"
                    + swPackage.getName() + "_CyclicDependency.xml";
            outFile = new PrintWriter(new BufferedWriter(new FileWriter(strCyclicDependencyOut)));
            outFile.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            outFile.write("<CyclicDependencyFile>");

            for(Entry<String,Set<String>> entry : fileForward.entrySet()) {
                String curr = entry.getKey();
                for(String other : entry.getValue()) {
                    Set<String> otherRefs = fileBackward.get(other);
                    if( otherRefs == null ) continue;
                    if( otherRefs.contains(curr) ) {
                        outFile.write("<CyclicDepedency FileName = \""
                                + fileNames.get(curr).getPath()
                                + "\""
                                + " CyclicFileName = \""
                                + fileNames.get(other).getPath()
                                + "\" />");
                    }
                }
            }


            outFile.write("</CyclicDependencyFile>");
            outFile.flush();
            outFile.close();
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}