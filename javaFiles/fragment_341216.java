//colRef is a reference/path to your collection
//filter by type with .whereEqualTo("field", "type")


colRef.whereEqualTo("type", "yourType")
            .get()
            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                            //add to your arraylist
                        }
                    } else {
                        Toast.makeText(getContext(), "fail to get docs", Toast.LENGTH_SHORT).show();
                    }
                }
            });


//repeat the process for the second type
//if you have more types I suggest using another approach