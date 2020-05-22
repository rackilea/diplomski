checkboxes = new CheckBox[3];

    for (int i = 0; i < checkboxes.length; i++) {
            String checkboxID = "checkBox" + (i + 1);

            int resID = getResources().getIdentifier(checkboxID, "id",
                    getPackageName());
            checkboxes[i] = ((CheckBox) findViewById(resID));
            checkboxes[i].setOnCheckedChangeListener(this);
            allCheckBoxes.add(checkboxes[i]);
    }