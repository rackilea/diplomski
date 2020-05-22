pDialog = new ProgressDialog(this);
//The next two methods will ensure that the user is unable to 
//cancel the Progress Dialog unless you explicitly 
//do so by calling `pDialog.dismiss();`
pDialog.setCancelable(false);
pDialog.setCanceledOnTouchOutside(false);