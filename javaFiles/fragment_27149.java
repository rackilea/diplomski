LinearLayout buttonsView = new LinearLayout(this);
buttonsView.setOrientation(LinearLayout.VERTICAL);
for (int r = 0; r < 6; ++r)
{
    LinearLayout row = new LinearLayout(this);
    row.setOrientation(LinearLayout.HORIZONTAL);
    for (int c = 0; c < 4; ++c)
    {
        Button btn = new Button(this);
        btn.setText("A");
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
        lp.weight = 1.0f;
        row.addView(btn, lp);
    }
    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
    lp.weight = 1.0f;
    buttonsView.addView(row, lp);
}  

ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
setContentView(buttonsView, lp);