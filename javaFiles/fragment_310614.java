LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
PopupWindow popup = new PopupWindow(
    inflater.inflate(R.layout.popup_window, null, false),
    WindowManager.LayoutParams.WRAP_CONTENT,
    WindowManager.LayoutParams.WRAP_CONTENT,
    true
);
popup.showAtLocation(
    findViewById(R.id.main),
    Gravity.END | Gravity.TOP,
    dpToPx(16),
    dpToPx(42)
);