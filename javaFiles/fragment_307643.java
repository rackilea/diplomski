private void navigateToPhotoEditActivity(Context context, Bundle bundle) 
       {
    Intent intent = new Intent(context, MainActivity.class);
    if (bundle != null) {
      intent.putExtras(bundle);
    }
     startActivity(intent);
    }