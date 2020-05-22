int currentapiVersion = android.os.Build.VERSION.SDK_INT;
    Drawable icon = new BitmapDrawable(this.getResources(),photo);
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle(getString(R.string.business_post_camera_dialog_title))
            .setMessage(getString(R.string.business_post_camera_dialog_message))
            .setCancelable(false)
            .setPositiveButton(R.string.sign_confirm_btn, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    doSomething();
                }
            })
            .setNegativeButton(R.string.sign_cancel_btn, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // do nothing
                }
            });


         if (currentapiVersion >= android.os.Build.VERSION_CODES.LOLLIPOP){

          builder.setIcon(-1).setIcon(icon);

         } else{
                 builder.setIcon(icon);
        }
    AlertDialog alert = builder.create();
    alert.show();