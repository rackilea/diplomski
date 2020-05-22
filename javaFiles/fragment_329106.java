ListView lv = (ListView) findViewById(R.id.my_list_id);
    Intent callingIntent= getIntent();
    if(callingIntent.hasExtra("Barcode")) {
        ArrayList<String> listOfBarcodes = callingIntent.getStringArrayListExtra("Barcode");
        completeList.addAll(listOfBarcodes);
        ArrayAdapter<String> aA = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, completeList);
        lv.setAdapter(aA);
    }else{
        // No scanned handle here
    }