@Override
public void onBackPressed() {
    if(popupWindow.isShowing())
        popupWindow.dismiss();
    else
    super.onBackPressed();
}