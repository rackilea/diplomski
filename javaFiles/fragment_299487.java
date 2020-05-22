final LinearLayout linearLayout = findViewById(R.id.webLinLayout);

LayoutInflater inflater =
        (LayoutInflater)
                getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);

final ViewGroup container =
        (ViewGroup) inflater.inflate(R.layout.activity_popup_window, null);

boolean focusable = false;

final PopupWindow popupWindow = new PopupWindow(container, 500, 500, focusable);
linearLayout.post(new Runnable() {
    public void run() {
        popupWindow.showAtLocation(linearLayout, Gravity.CENTER, 0, 0);
    }
});