AlertDialog.Builder builder = new AlertDialog.Builder(your_activity.this);
builder.setTitle(!puzzle.isSolved() ? R.string.title_stats : stats.isNewBest() ? R.string.title_new_record : R.string.title_solved);
builder.setMessage(msg);
builder.setPositiveButton(R.string.label_ok, new DialogInterface.OnClickListener() {
    public void onClick(DialogInterface dialog, int id) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www..com"));
        Bundle b = new Bundle();
        b.putBoolean("new_window", true); //sets new window
        intent.putExtras(b);
        startActivity(intent);
     }
});
builder.show();