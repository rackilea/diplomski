LinearLayout mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
    RelativeLayout fm = new RelativeLayout(this);
    RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
    fm.setLayoutParams(lp);
    fm.setBackgroundColor(Color.CYAN);

    Button done = new Button(this);
    done.setId(10);
    done.setText("Done");

    Button save = new Button(this);
    save.setId(12);
    save.setText("Save");

    TextView formManager = new TextView(this);
    formManager.setId(11);
    formManager.setText("Form Manager");

    RelativeLayout.LayoutParams lpp = new RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
    formManager.setLayoutParams(lpp);
    lpp.addRule(RelativeLayout.CENTER_IN_PARENT);
    fm.addView(formManager, lpp);

    RelativeLayout.LayoutParams doneLayoutParams = new RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
    done.setLayoutParams(doneLayoutParams);
    doneLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
    fm.addView(done, doneLayoutParams);

    RelativeLayout.LayoutParams saveLayoutParams = new RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
    save.setLayoutParams(saveLayoutParams);
    saveLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
    fm.addView(save, saveLayoutParams);


    mainLayout.addView(fm);