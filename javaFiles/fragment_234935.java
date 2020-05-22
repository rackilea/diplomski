protected boolean store_cash(){
   SharedPreferences settings = getSharedPreferences("GENERAL", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putFloat("cash", mCash);
        return editor.commit();
}
protected void load_cash(){
 SharedPreferences settings = getSharedPreferences("GENERAL", 0);
 mCash = settings.getFloat("cash", (float) 0.0);
}