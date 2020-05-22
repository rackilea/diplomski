public static void call(Context context, String number) {
    Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
    try {
      context.startActivity(i);
    } catch (Exception e) {
      // this can happen if the device can't make phone calls
      // for example, a tablet
    }
  }