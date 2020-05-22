builder.setSingleChoiceItems(choiceList, selected, new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface arg0, int arg1) {
        mSelected = arg1;
    }
});