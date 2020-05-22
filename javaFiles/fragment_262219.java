private boolean updateProdus(String id, String number){

DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("produse").push();

databaseReference.child("number").setValue(number);
Toast.makeText(this, "Edited", Toast.LENGTH_LONG).show();
return true;
}