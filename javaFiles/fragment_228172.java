@Override
public void onDestroy(){
    super.onDestroy();
    Log.i("OnDestroy", "Logged");
    SharedPreferences prefs = getActivity().getSharedPreferences("name", Context.MODE_PRIVATE); 
    Editor editor = prefs.edit();
    editor.putString("stringName", stringToStore);
    editor.commit();
}