public void createButtons() {
    actionButtons = server.getActionButtons();
    TableLayout buttonLayout = (TableLayout) rootView.findViewById(R.id.tblLayoutButtons);

    for(int i=0; i< actionButtons.length; i++)
    {
        btnAction.setWidth(100);
        btnAction.setHeight(50);
        btnAction.setTag(actionButtons[i]);
        btnAction.setText(actionButtons[i].getName());
        btnAction.setOnClickListener(btnActionClick);
        btnAction.setId(i);
        buttonLayout.addView(btnAction);
    }
}

public void updateButton() {
    //Get the ID of the button to toggle from the server and get the related view
    ToggleButton buttonToToggle = (ToggleButton) findViewById(Integer.parseInt(server.getMessage()));
    if (buttonToToggle.isChecked()) {
        buttonToToggle.setChecked(false);
        buttonToToggle.setBackground(R.drawable.offImage)
    }
    else {
        buttonToToggle.setChecked(true);
        buttonToToggle.setBackground(R.drawable.onImage)
    }
}