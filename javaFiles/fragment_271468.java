AlertDialog alertDialog;    
public void open(){
          AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
          alertDialogBuilder.setMessage("Are you sure,
             You wanted to delete?");
          alertDialogBuilder.setPositiveButton("yes", 
             new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface arg0, int arg1) {
                deleteValue();
             }
          });

          alertDialogBuilder.setNegativeButton("No",null);

          alertDialog = alertDialogBuilder.create();
          alertDialog.show();
    }

    public void deleteValue(){
     mDatabase.child("users").child(mUserId).child("items")
                            .orderByChild("title")
                            .equalTo((String) listView.getItemAtPosition(position))
                            .addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    if (dataSnapshot.hasChildren()) {
                                        DataSnapshot firstChild = dataSnapshot.getChildren().iterator().next();
                                        firstChild.getRef().removeValue();
alertDialog.dismiss();
                                    }
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });
    }