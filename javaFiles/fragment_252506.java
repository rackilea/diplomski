setupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String userName = setupName.getText().toString();

                CollectionReference usersRef = firestore.collection("Users");
                Query query = usersRef.whereEqualTo("username", userName);
                query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(DocumentSnapshot documentSnapshot : task.getResult()){
                                String user = documentSnapshot.getString("username");

                                if(user.equals(userName)){
                                    Log.d(TAG, "User Exists");
                                    Toast.makeText(MainActivity.this, "Username exists", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }

                        if(task.getResult().size() == 0 ){
                            Log.d(TAG, "User not Exists");
                            //You can store new user information here

                        }
                    }
                });
            }
        });