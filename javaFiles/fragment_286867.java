setContentView(R.layout.main);
int buttonsNumber = 5; // Put here your number of buttons
LinearLayout col0 = (LinearLayout) findViewById(R.id.col0);

for(int i = 0; i < buttonsNumber; i++)
{
    try
    {
        Button newButton = new Button(this);
        newButton.setId(R.id.class.getField("b"+i).getInt(null));
        // Since API Level 17, you can also use View.generateViewId()
        newButton.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 0, 1));
        col0.addView(newButton);
    }
    catch (Exception e)
    {
        // Unknown button id !
        // We skip it
    }
}

TextView v0 = (TextView) findViewById(R.id.v0);
v0.setLayoutParams(new TableLayout.LayoutParams(LayoutParams.match_parent, 0, buttonsNumber - 1));