public void load_list_view() {

        String email = getEmail();
        final DocumentReference docRef = firestore.collection("users").document(email);

        docRef.collection("Group")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for (QueryDocumentSnapshot document : queryDocumentSnapshots) {

                            //Extracting Group name from each document

                            titleString = document.getId();
                            titleArray.add(titleString);

                            //Extracting participants ArrayList from each document

                            partecipantsArray.add((ArrayList<String>) document.get("participant"));
                            numArray.add(num_partecipants);
                            firstChar = Character.toString(titleString.charAt(0));
                            firstCharArray.add(firstChar);

                        }

                        num_partecipants = partecipantsArray.size();
                        numArray.add(num_partecipants);
                        trash = R.drawable.trash_icon;
                        firstChar = Character.toString(titleString.charAt(0));
                        firstCharArray.add(firstChar);
                        customAdapter = new GroupAdapter(GroupActivity.this, firstCharArray, titleArray, numArray, trash);
                        listView.setAdapter(customAdapter);

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //HANDLE EXCEPTION
                    }
                });
    }