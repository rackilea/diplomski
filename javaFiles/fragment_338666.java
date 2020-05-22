RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relative_layout_id);
AnimationDrawable animationDrawable = (AnimationDrawable) relativeLayout.getBackground();

mybutton.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View v) {
            animationDrawable.start();
    }
});