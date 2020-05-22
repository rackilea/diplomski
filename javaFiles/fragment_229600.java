@Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
        String song = extras.getString("song");
        }
...
}