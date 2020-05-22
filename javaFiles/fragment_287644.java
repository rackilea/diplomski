SharedPreferences.Editor editor; 
// ^^^^^^^^^^  declare it outside

@Override
public void onCreate() {
    super.onCreate();
    editor=getSharedPreferences("DateStep",MODE_PRIVATE).edit();
        // initialize editor
}