@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
private int getDisplayWidth(Display display){
    if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.HONEYCOMB_MR2) {
      Point size = new Point();
      display.getSize(size);
      return size.x;
    }

    return display.getWidth();
}