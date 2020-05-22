int numberOfButtons = getIntent().getExtras().getInt("numberOfButtons", 0);
    for (int i = 1; i <= numberOfButtons; ++i)
    {
        Button btn = new Button(this);
        btn.setText("Button n° " + i);

        // YOUR_WIDGET_THAT_WILL_CONTAIN_YOUr_BUTTONS.addView(btn);

    }