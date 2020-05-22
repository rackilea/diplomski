@Override
public void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error) {
final AlertDialog.Builder builder = new AlertDialog.Builder(this);
 builder.setMessage(R.string.notification_error_ssl_cert_invalid);
  builder.setPositiveButton("continue", new DialogInterface.OnClickListener() {
   @Override
   public void onClick(DialogInterface dialog, int which) {
       handler.proceed();
   }
 });
builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
   @Override
   public void onClick(DialogInterface dialog, int which) {
       handler.cancel();
   }
  });
  final AlertDialog dialog = builder.create();
 dialog.show();
}