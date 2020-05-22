public void readData(MyCallback myCallback) {
    String id;
    EditText animalIdEditText = findViewById(R.id.animalIDsearch);
    String animalId = animalIdEditText.getText().toString();
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    DocumentReference docRef = db.collection("Animals").document(animalId);
    docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
        @Override
        public void onSuccess(DocumentSnapshot documentSnapshot) {
            Animal animal = documentSnapshot.toObject(Animal.class);
            myCallback.onCallback(animal);
        }
    });
}