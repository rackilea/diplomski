class DbBackend {
    public static void printInspectorFormat(Context context) {
        try {
            Log.d(null,"1234545");
            DataBaseHelper myDbHelper = new DataBaseHelper(context.getApplicationContext());
            try { 
            myDbHelper.createDataBase();  
            } catch (IOException ioe) { 
            throw new Error("Unable to create database"); 
            }  
            try {  
            myDbHelper.openDataBase();         
            }catch(SQLException sqle){  
            throw sqle;  
            }
    }
}