this is the frag that "writes":
private SharedPreferences prefs;  // shared preferences 
prefs = getActivity().getSharedPreferences("spa", Context.MODE_PRIVATE); 
SharedPreferences.Editor editor = prefs.edit();
editor.putString("someId", "something");  //or you can use putInt, putBoolean ... 
editor.commit();

this is the frag the "reads"
prefs = getActivity().getSharedPreferences("spa", Context.MODE_PRIVATE);
String someId=prefs.getString("someId",someId);