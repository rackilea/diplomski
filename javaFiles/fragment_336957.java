Uri uri = Uri.parse("fb-messenger://user/100005727832736");

Intent toMessenger= new Intent(Intent.ACTION_VIEW, uri);
try {
        startActivity(toMessenger);
    } 
catch (android.content.ActivityNotFoundException ex) 
    {
        Toast.makeText(context, "Please Install Facebook Messenger",    Toast.LENGTH_LONG).show();
}
}