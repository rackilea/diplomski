LayoutInflater inflater = (LayoutInflater) YourActivity.this
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View layout = inflater.inflate(R.layout.popup_xml,
            (ViewGroup) findViewById(R.id.popup_element));
    popupWindow = new PopupWindow(layout, 300, 190, true);

    popupText = (TextView) layout.findViewById(R.id.popupText);
    popupText.setText(yourString);