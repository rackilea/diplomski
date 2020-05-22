//globally declare it
    SharedPreferences.Editor editor;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filters); 

    editor = getSharedPreferences("STATE", MODE_PRIVATE).edit();
     SharedPreferences settings = 
      PreferenceManager.getDefaultSharedPreferences(this);
    boolean state = settings.getBoolean("isChecked", false);
    if(state){
    //set the checkbox checked
    }else{
    //set the checkbox Unchecked
    }
    }
}


    else if (id == R.id.favourites){
            if (item.isChecked()) {
            item.setChecked(false);
            editor.putBoolean("isChecked", false)
             editor.apply();

            }

            else {
            item.setChecked(true);
             editor.putBoolean("isChecked", true)
             editor.apply();
            }
            return true;
      }