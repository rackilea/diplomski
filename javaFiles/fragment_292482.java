label = new String[] {"A","B","C","D"};
value = new String[]{modelList.get(0).getbill(),modelList.get(0).getaccepting(),
        modelList.get(0).getdeclining(),modelList.get(0).getwaiting()};

holder.ll.removeAllViews();

for (int i = 0; i < label.length; i++) {

    TableRow row= new TableRow(mContext);
    row.setGravity(Gravity.CENTER);
    TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
    row.setLayoutParams(lp);

    //...

}