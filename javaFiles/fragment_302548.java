/**
* Method called to intiate the scan (it's linked to a button)
*/
public void doScan(View view) {
    IntentIntegrator scanIntegrator = new IntentIntegrator(this);
    scanIntegrator.initiateScan();
}

// when you click the Scan Bar Code button
public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);

    if (scanningResult != null) { // we have a result


           String scanContent = scanningResult.getContents(); // set the content of the scan.
           String scanFormat = scanningResult.getFormatName(); // set the type of scan.

           // You will want to put this data somewhere else, globals, etc.

        } else {
            toast("No scan data received!"); // call to make a toast
        }
    }