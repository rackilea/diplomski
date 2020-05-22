// arbitrary number of your choosing
final int SUPERUSER_REQUEST = 2323; 

// superuser request
Intent intent = new Intent("android.intent.action.superuser"); 

// tell Superuser the name of the requesting app
intent.putExtra("name", "Shell"); 

// tel Superuser the name of the requesting package
intent.putExtra("packagename", "koushikdutta.shell"); 

// make the request!
startActivityForResult(intent, SUPERUSER_REQUEST);