for(int i=0;i<ROW_COUNT;i++){
    for(j=0;j<COLUMN_COUNT;j++){
        int editTextId=getResId("box"+i+j,this,id.class);
        int textViewId=getResId("answerbox"+i+j,this,id.class);

        EditText et=(EditText)findViewById(editTextId);
        TextView tv=(TextView)findViewById(textViewId);

       //Then do your comparison as you like and do the rest. 
    }   
}

public static int getResId(String variableName, Context context, Class<?> c) {

    try {
        Field idField = c.getDeclaredField(variableName);
        return idField.getInt(idField);
    } catch (Exception e) {
        e.printStackTrace();
        return -1;
    } 
}