only this code should be placed in onCreate()

    etV0 = (EditText) findViewById(R.id.etV0);
    etV1 = (EditText) findViewById(R.id.etV1);
    etT0 = (EditText) findViewById(R.id.etT0);
    etT1 = (EditText) findViewById(R.id.etT1);
    tvAccResult = (TextView) findViewById(R.id.tvAccResult);
    accC = (Button) findViewById(R.id.accC);


and this code should be present in the block of event fired (like when button ***accC*** is clicked):


    CetV0 = (Double.parseDouble(etV0.getText().toString()));
    CetV1 = (Double.parseDouble(etV1.getText().toString()));
    CetT0 = (Double.parseDouble(etT0.getText().toString()));
    CetT1 = (Double.parseDouble(etT1.getText().toString()));

    CtvAccResult = (double) ((CetV0 - CetV1) / (CetT0 - CetT1));