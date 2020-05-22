tv.setOnLongClickListener(new View.OnLongClickListener() {

    @Override
    public boolean onLongClick(View v) {

        Toast.makeText(HomeSafeActivity.this, "Long preess", Toast.LENGTH_LONG).show();

        return true;
    }
});