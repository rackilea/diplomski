getSupportFragmentManager().beginTransaction()
     .replace(R.id.framelayout,new MyFragment1())
     .commit();

final Fragment fragmentInFrame = getSupportFragmentManager().findFragmentById(R.id.framelayout);

if (fragmentInFrame instanceof MyFragment1){
      Log.d("debug", "you are in MyFragment1");
} else if (fragmentInFrame instanceof MyFragment2) {
      Log.d("debug", "you are in MyFragment2");
}