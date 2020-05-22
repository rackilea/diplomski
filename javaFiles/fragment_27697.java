public void addToCloudStore(String filename, String path, Class<?> cl){
    try {
        InputStreamReader is = new InputStreamReader(getAssets()
                .open(filename));
        CsvRoutines routines = new CsvRoutines();
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        for (Object obj : routines.iterate(cl, is)) {
            firestore.collection(path).add(obj);
        }

    } catch(IOException ex){
        System.out.println("Exception");
        ex.printStackTrace();
    }
}