try {
        System.out.println(d.detectDrive()); 
        Runtime rt = Runtime.getRuntime();
        String drive = d.detectDrive();
        // <<---append the return value to the compose Batch command string--->>
        Process p = rt.exec("cmd /c start "+drive+"\\MyBatchFile.bat");
    } 
    catch (IOException e) {
        e.printStackTrace();
    }