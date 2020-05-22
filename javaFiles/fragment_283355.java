if(qrCodes.size()>0)
    {

        barcodeDetector.release(); //stops the scanner from reading multiple values
        qrResult.post(new Runnable() {
            @Override
            public void run() {

                qrResult.setText(qrCodes.valueAt(0).displayValue);
                Intent intent = new Intent(QrScanner.this,Info.class);
                intent.putExtra(QR_CODE,qrCodes.valueAt(0).displayValue);
                startActivity(intent);
            }
        });
    }