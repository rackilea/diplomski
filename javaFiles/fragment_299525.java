TextView tv = new TextView(this);
...
gridlayout.addView(tv);

tv.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        removeViewSelected();
    }
});

tv.setOnLongClickListener(new View.OnLongClickListener() {
    @Override
    public boolean onLongClick(View view) {
        setViewSelected(view);
        return true;
    }
});