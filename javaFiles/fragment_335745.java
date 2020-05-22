File file1 = new File("/sdcard/SampleProjectApp/WindsorONE_Mobile_Molding.pdf");
    File file2 = new File("/sdcard/SampleProjectApp/WindsorONE_Mobile_PK.pdf");
    File file3 = new File("/sdcard/SampleProjectApp/Alone.mp4");

    if(!((file1.exists())) || !((file2.exists())) || !((file3.exists()))) {
        ArrayList<String> files = new ArrayList<String>();
        files.add("WindsorONE_Mobile_Molding.pdf");         
        files.add("WindsorONE_Mobile_PK.pdf"); 
        files.add("Alone.mp4");
        new myAsyncTask().execute(files);
    }