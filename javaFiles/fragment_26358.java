public void moveButton() {
        View button1 = findViewById(R.id.button1);

        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)button1.getLayoutParams();
        layoutParams.removeRule(RelativeLayout.ALIGN_PARENT_TOP);
        layoutParams.removeRule(RelativeLayout.ALIGN_PARENT_LEFT);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        layoutParams.width = 350;
        layoutParams.height = 200;
        button1.setLayoutParams(layoutParams);
}