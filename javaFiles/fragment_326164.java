@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    switch (requestCode) {
        case 123:
            // HANDLE BARCODE
            break;

        case 456:
            // HANDLE IMAGE
            break;
    }
}