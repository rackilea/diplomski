final ViewHolder finalHolder = holder;    // <- added

holder.btnAdd.setOnClickListener(new OnClickListener() {

    @Override
    public void onClick(View v) {
        String quantity = finalHolder.etQty.getText().toString();
        //                ^^^^^^^^^^^
        System.out.println(quantity);
    }
});