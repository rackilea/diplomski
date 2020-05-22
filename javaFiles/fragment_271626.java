String filename = "index.html"; 

    int indexOfFinalDot = filename.lastIndexOf(".");
    if (indexOfFinalDot > 0) {
        String fileExtentsion = filename.substring(indexOfFinalDot + 1).toLowerCase();
        if ("html".equals(fileExtentsion)) {
           //your logic here
        }
    }