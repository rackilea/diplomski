try {
    Intent i = new Intent("android.intent.action.MAIN"); 
    ComponentName n = new 
    ComponentName("de.yanniks.myapp", 
    "de.yanniks.myapp.MyAppActivity"); 
    i.setComponent(n); 
    startActivity(i); 
} catch(ActivityNotFoundException e) {
    Intent intent = new Intent(Intent.ACTION_VIEW);
    intent.setData(Uri.parse("market://details?id=de.yanniks.myapp"));
    startActivity(intent);
}