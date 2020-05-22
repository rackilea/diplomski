//int inc = 1;
//Intent GoToMain = getIntent();                     //Comment all this..
//inc = GoToMain.getIntExtra("IncSave", 1);


SharedPreferences GetSavedinc=getSharedPreferences("IncSave", Context.MODE_PRIVATE);
int  IncSave=GetSavedUpCount.getInt("IncSave", 1);
Log.v("My Value",IncSave+"");