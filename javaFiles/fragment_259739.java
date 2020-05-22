builder.setPositiveButton("Sounds Good", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialog, int id) {
        final CharSequence item = choiceList[mSelected];
        Toast.makeText(mContext, item, Toast.LENGTH_LONG).show();
        dialog.dismiss();
    }
});