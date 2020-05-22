LinearLayout.LayoutParams params =
    new LinearLayout.LayoutParams(
        LayoutParams.FILL_PARENT,
        LayoutParams.WRAP_CONTENT);
params.gravity = Gravity.CENTER_HORIZONTAL;
params.weight = 1;
this.addView(block, params);