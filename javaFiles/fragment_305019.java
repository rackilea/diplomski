public String[] loadArray(String arrayName) {  
    SharedPreferences prefs = getSharedPreferences("preferencename", 0);  
    int size = prefs.getInt(arrayName + "_size", 0);  
    String array[] = new String[size];  
    for(int i=0;i<size;i++)  
        array[i] = prefs.getString(arrayName + "_" + i, null);  
    return array;  
}  

public boolean saveArray(String[] array, String arrayName) {   
    SharedPreferences prefs = getSharedPreferences("preferencename", 0);  
    SharedPreferences.Editor editor = prefs.edit();  
    editor.putInt(arrayName +"_size", array.length);  
    for(int i=0;i<array.length;i++)  
        editor.putString(arrayName + "_" + i, array[i]);  
    return editor.commit();  
}