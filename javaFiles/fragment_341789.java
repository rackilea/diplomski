@Override
    public void onClick(View v) {
      IntentIntegrator integrator = new IntentIntegrator(MainActivity.this);
      integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
      //in case you want to customize a bit.
      integrator.setPrompt("Scan a QR/Bar code");
      integrator.setCameraId(0);
      integrator.setBeepEnabled(false);
      integrator.initiateScan();
    }