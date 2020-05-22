FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser(); 
DatabaseReference reference;
firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    progressDialog.dismiss();
                    if(task.isSuccessful()){

                        //The task is successful || Task Login
                       Toast.makeText(getApplicationContext(),"Successfully Login",Toast.LENGTH_LONG).show(); 
                       reference = FirebaseDatabase.getInstance().
                       getReference("dbname").child(user.getUid());


                       reference.addListenerForSingleValueEvent(new ValueEventListener() {
                       @Override
                       public void onDataChange(DataSnapshot dataSnapshot) {
                       for(DataSnapshot datas: dataSnapshot.getChildren()){
                       String usertype=datas.child("user").getValue().toString();

                       // If the users is professor but if it is 
                            // student go to userStudent.class
                       if(usertype.equals("Student")){

                         startActivity(new      
                         Intent(getApplicationContext(),studentProfile.class));
                         finish();

                       }else if (usertype.equals("Professor")) {
                         startActivity(new      
                         Intent(getApplicationContext(),professorProfile.class));
                         finish();
                       }

                      }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                  });






    }