for (int i = 0; i < 100; i++)
{
    Button button = new Button(this);
    int _id = getResources().getIdentifier("b" + (i+1), "id", this.getPackageName());
    button.setTag(_id);
    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, 0);
    params.weight = 1;
    params.gravity = Gravity.CENTER;
    button.setLayoutParams(params);
    button.setTextSize(18);
    myLinearLayout.addView(button);//myLinearLayout is your parent LinearLayout.
}