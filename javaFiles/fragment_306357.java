if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
   AlertDialog.setMessage(Html.fromHtml("Hello "+"<b>"+"World"+"</b>", Html.FROM_HTML_MODE_LEGACY));
} else {
   @Suppress("DEPRECATION")
   AlertDialog.setMessage(Html.fromHtml("Hello "+"<b>"+"World"+"</b>"));
}