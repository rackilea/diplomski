@Override
public void OnCreate(){
    ...
    // get ImageView instance like this. 
    ImageView YOU = (ImageView) findViewById(R.id.imageviewId);
    ...
    // And set it. 
    YOU.setOnTouchListener(this);
}