AlertDialog.Builder builder = new AlertDialog.Builder(NewTableActivity.this);
builder.setTitle(R.string.addComponent);

final EditText titleText = new EditText(NewTableActivity.this);
titleText.setHint(R.string.title);

builder.setView(titleText);
builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
});
builder.setPositiveButton(R.string.ok, null);
final AlertDialog alertDialog = builder.create();
alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
    @Override
    public void onShow(DialogInterface dialogInterface) {
        Log.e("TEst", "Doung");
        Button button = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
    }
});

alertDialog.show();