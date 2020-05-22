// Define empty list of user names, which you will populate later with recursion
List<String> userNames = new ArrayList<String>();
// Connect adapter with empty list
ArrayAdapter<String> adapter = new ArrayAdapter<>(TutorsListActivity.this, R.layout.item_subtopic, userNames);
// Set adapter to ListView
sListView2.setAdapter(adapter);

// Call recursion with list of uids and starting index of 0
getUserSync(list, 0);


private void getUserSync(List<String> list, int i) {
    if (i < 0 || i > list.length - 1) {
        // If index i is out of bounds for list, we break the recursion
        return;
    }

    String uid = list.get(i);

    Toast.makeText(TutorsListActivity.this, uid, Toast.LENGTH_LONG).show();

    subTopicsDatabase.collection("users").document(uid).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
        @Override
        public void onSuccess(DocumentSnapshot documentSnapshot) {
            // When we load document, we fetch name and add it to the list which is connected to adapter
            // After that, we call adapter.notifyDataSetChanged which will update ui
            // When all that is done, we call getUserSync, to fetch user name for next uid
            if (documentSnapshot.exists()) {
                String stName = documentSnapshot.getString("name");
                if (stName != null) {
                    userNames.add(stName);
                    adapter.notifyDataSetChanged();
                }
            }
            getUserSync(list, i++);
        }
    }).addOnFailureListener(new OnFailureListener() {
        @Override
        public void onFailure(@NonNull Exception e) {
            // If enything goes wrong, we break the recursion
            return;
        }
    });
}