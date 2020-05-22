public void showImage() {
    Dialog builder = new Dialog(this);
    builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
    builder.getWindow().setBackgroundDrawable(
            new ColorDrawable(android.graphics.Color.TRANSPARENT));
    builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
        @Override
        public void onDismiss(DialogInterface dialogInterface) {
            //nothing;
        }
    });

    final ProgressDialog progressDialog = new ProgressDialog(this);
    ImageView imageView = new ImageView(this);
    Picasso.with(this)
            .load("http://camranger.com/wp-content/uploads/2014/10/Android-Icon.png")
            .into(imageView, new com.squareup.picasso.Callback() {
                @Override
                public void onSuccess() {

                    // The image has loaded you can make the progress bar invisible
                    if (progressDialog.isShowing())
                        progressDialog.dismiss();
                }

                @Override
                public void onError() {
                    // Show some error message
                    if (progressDialog.isShowing())
                        progressDialog.dismiss();
                }
            });


    builder.addContentView(imageView, new RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT));
    builder.show();

    progressDialog.setMessage("please wait");
    progressDialog.setCancelable(false);
    progressDialog.show();
}