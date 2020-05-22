LayoutInflater layoutInflater = (LayoutInflater)getBaseContext()
        .getSystemService(LAYOUT_INFLATER_SERVICE);  
View popupView = layoutInflater.inflate(R.layout.popup, null);  
final PopupWindow popupWindow = new PopupWindow(popupView,
        LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
popupWindow.showAtLocation(...); // or showAsDropdown(...)