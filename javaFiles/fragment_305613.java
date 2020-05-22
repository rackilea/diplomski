CollectionReference ref = firebaseFirestore.collection("Users").document(currentUserUID)
                .collection("Types of Meals").document("Breakfast")
                .collection("Date of Breakfast").document(date)
                .collection("List of Products");

ref.whereEqualTo("name", name).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()) {
                    for(DocumentSnapshot documentSnapshot: task.getResult().getDocuments()) {
                      Map<String, Object> data = new HashMap<>();
                        data.put("weight", 200);
                        ref.document(documentSnapshot.getId()).set(data, SetOptions.merge());
                    }
                }
            }
        });