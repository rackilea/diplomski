/**This counts the
         * total number of files present inside the subdirectory too.
         */
        Map<String, Integer> noOfFilesInFolder = new HashMap<String, Integer>();
        for (String pathOfFolder:foldersPath){
            int filesCount = 0;
            File[] files2 = new File(pathOfFolder).listFiles();//get the arrays of files
            for (File f2 : files2){
                if (f2.isDirectory()){
                    filesCount += new File(f2.toString()).listFiles().length;

                }
                else{
                    filesCount++;
                }
            }
            System.out.println(filesCount);
            noOfFilesInFolder.put(pathOfFolder, filesCount);
        }

        System.out.println(noOfFilesInFolder);
    }