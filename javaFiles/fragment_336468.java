String dir = "/storage/emulated/0/Download/";
        File f = new File(dir);
        String[] files = f.list();
        for(int i=0; i<files.length; i++){
            Log.d("tag", files[i]);
        }