public void onCreate(Bundle savedInstanceState) {
    setContentView(R.layout.main);
    String videourl = "http://something.com/blah.mp4";
    Uri uri = Uri.parse(videourl);
    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
    intent.setDataAndType(uri, "video/mp4");
    startActivity(intent);
}