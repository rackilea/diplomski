Bundle extra = getIntent().getExtras();
    if (extra != null) {
        String textViewName = extra.getString("SomeTag");
        tvgroup.setText(textViewName);
    }

    Bundle extra2 = getIntent().getExtras();
    if (extra2 != null) {
        String status = extra2.getString("SomeTag");
        tvstatus.setText(status);
    }