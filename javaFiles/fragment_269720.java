FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
CollectionReference subjectsRef = rootRef.collection("subjects");
Spinner spinner = (Spinner) findViewById(R.id.spinner);
List<String> subjects = new ArrayList<>();
ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, subjects);
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
spinner.setAdapter(adapter);
subjectsRefRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            for (QueryDocumentSnapshot document : task.getResult()) {
                String subject = document.getString("name");
                subjects.add(subject);
            }
            adapter.notifyDataSetChanged();
        }
    }
});