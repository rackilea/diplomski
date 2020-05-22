for (int i = 0; i < MainActivity.barcodesList.size(); i++) {
        if (MainActivity.barcodesList.get(i).getBarcodeNo().equalsIgnoreCase(currentBarcode)) {
            Toast.makeText(this, "Duplicate QR Code : " + currentBarcode, Toast.LENGTH_SHORT).show();
            return;
        }
    }
    BarcodeModel bm = new BarcodeModel();
    bm.setBarcodeNo(currentBarcode);
    MainActivity.barcodesList.add(bm);