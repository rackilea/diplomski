Intent intent = getIntent();
String username = "";

if(intent != null) {
    username = intent.getStringExtra(name);
}