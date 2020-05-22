@Override
public void getResultFromAsynTask(String result) {
    // Do what you need with the result like starting your new Activity and passing the path
    final Intent intent = new Intent();
    intent.setClass(MainActivity.this, Player.class);
    intent.putExtra("path", result);
    startActivity(intent);
}