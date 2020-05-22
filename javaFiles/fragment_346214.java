private int mIntPaid;

private void myBlockMethod{


     if(FirebaseAuth.getInstance().getCurrentUser()!=null){

            final DatabaseReference paidRef = FirebaseDatabase.getInstance().getReference().child("Users").child(mAuth.getCurrentUser().getUid()).child("Paid");

            paidRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot dataSnapshotPaid) {

            mIntPaid = Integer.valueOf(dataSnapshotPaid.getValue().toString());

    //And then just check if that value is 0 or 1 to send the user to the block activity

          if (mIntPaid == 0) {
                                                //continue using app 
    {else if (mIntPaid == 1) {
    //app block
                                                        Intent mainIntent = new Intent().setClass(MainActivity.this, ExpiredLicence.class);
                                                        startActivity(mainIntent);
                                                        finish();
        }


    }
}