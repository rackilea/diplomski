private void setRecord(int i ) {

    SharedPreferences prefs = getSharedPreferences("data", Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = prefs.edit();

    if(i > prefs.getInt("record", 0))
        editor.putInt("record", i);

    editor.commit();
}