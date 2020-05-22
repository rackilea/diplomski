LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
View popupview = inflater.inflate(R.layout.popup_window, null);
int width = LinearLayout.LayoutParams.WRAP_CONTENT;
int height = LinearLayout.LayoutParams.WRAP_CONTENT;
popupWindow  = new PopupWindow(popupview, width, height, true);
popupWindow.showAtLocation(view, Gravity.CENTER, 0,0);
TextView sub_name = popupview.findViewById(R.id.subject_name);
sub_name.setText(names.get(i));