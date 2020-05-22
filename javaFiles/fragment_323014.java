class A {
    List<Map<String,String>> itemData;

    public A() {
        itemData = new ArrayList<>();
    }

    private void itemTable {
         ...
        int index =0;

        Map<String, String> itemselected = new HashMap<>();
        itemselected.put("invoiceNo", textViewInvNo.getText().toString());//d
        itemselected.put("cstName", textViewCstName.getText().toString());//d
        itemselected.put("contact", textViewCstph.getText().toString());//d
        itemselected.put("barcode", barCode.getText().toString());//d
        itemselected.put("desc", itemDesc.getText().toString());//d
        itemselected.put("weight", weightLine.getText().toString());//d
        itemselected.put("rate", rateAmount.getText().toString());//d
        itemselected.put("makingAmt", makingAmount.getText().toString());//d
        itemselected.put("net_rate", netRate.getText().toString());//d
        itemselected.put("itemTotal", itemtotal.getText().toString());//d
        itemselected.put("vat", textViewVat.getText().toString());//d
        itemselected.put("sum_total", textViewSum.getText().toString());//d
        itemselected.put("bill_type", billType);//null

        itemData.add(index,itemselected);
        index++;

         ...
    }
}