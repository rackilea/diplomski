LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));

        TextView titleView = new TextView(this);
        LayoutParams lparams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        titleView.setLayoutParams(lparams);
        titleView.setTextAppearance(this, android.R.attr.textAppearanceLarge);
        titleView.setText("Hallo Welt!");
        layout.addView(titleView);

        setContentView(layout);