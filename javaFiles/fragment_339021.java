try {
        File memoryFile = new File(getApplicationContext().getFilesDir(), filename);

        if(memoryFile.exists()){
                revealMarkers(memoryFile);
                Log.d(null, "revealed");
        }else{Log.d(null, "no file found");}
    } catch (FileNotFoundException ex) {
        Log.d(null, "file not found");
    }