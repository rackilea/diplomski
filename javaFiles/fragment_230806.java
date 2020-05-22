@Override
 public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    if(tbMusic.isChecked()) {
       getApplication().setSoundEnabled ( true );
    } else {
       getApplication().setSoundEnabled ( false ); 
    }
}