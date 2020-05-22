@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    switch (requestCode) {
        case IntentIntegrator.REQUEST_CODE: {
            if (resultCode != RESULT_CANCELED) {
                IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
                String data = scanResult.getContents();
                // use this data
            } else {
                // error
            }
            break;
        }
    }
}