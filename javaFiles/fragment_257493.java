private ArrayList buildFileList(File dirName) {
       if (dirName.isDirectory()) {
            File[] files = dirName.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    videoMatcher = patternVideo.matcher(file.getName());
                    audioMatcher = patternAudio.matcher(file.getName());
                    imageMatcher = patternImages.matcher(file.getName());
                    if (videoMatcher.find()) {
                        videoFiles.add(file.getAbsolutePath());
                    } else if (audioMatcher.find()) {
                        audioFiles.add(file.getAbsolutePath());
                    } else if (imageMatcher.find()) {
                        imageFiles.add(file.getAbsolutePath());
                    }
                } else if (file.isDirectory()) {
                    buildFileList(file);
                }
            }
        }
        //Combine your arrayLists here 
        return CombinedLists          //return the Combined Lists
    }