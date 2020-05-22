protected final void onActivityResult(int requestCode, int resultCode, final Intent data) {
if (requestCode == BARCODE_READER_REQUEST_CODE) {
    if (resultCode == CommonStatusCodes.SUCCESS) {
        if (data != null) {
            String myKey="";
            final Barcode barcode = data.getParcelableExtra(BarcodeCaptureActivity.BarcodeObject);
            Point[] p = barcode.cornerPoints;
             database.orderByChild("barcode").equalTo(barcode.displayValue).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot dataSnapshot) {
                    for (DataSnapshot objSnapshot : dataSnapshot.getChildren()) {
                        myKey = objSnapshot.getKey();
                        Toast.makeText(Inventory.this, myKey, Toast.LENGTH_SHORT).show();



                    }
                   Intent intent = new Intent(Inventory.this,Edit.class);
                   intent.putExtra("value", myKey);
                   startActivity(intent);

                }


                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
}
}