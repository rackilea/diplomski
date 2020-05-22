ProgressBar progressBar = findViewById(R.id.progressBar); // Get ProgressBar reference
ConstraintLayout mainContent = findViewById(R.id.mainContent);
welcomeTv = findViewById(R.id.welcomeTv);
fStore = FirebaseFirestore.getInstance();


fStore.collection("Users").document(FirebaseAuth.getInstance().getCurrentUser().getUid()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
        @Override
        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
            progressBar.setVisibility(View.GONE); // Hide Progress bar 
            mainContent.setVisibility(View.VISIBLE); // Show TextView

            if (task.isSuccessful() && task.getResult() != null) {

                username = task.getResult().getString("username");
                welcomeTv.setText(username);

                //other stuff
            } else {
                Toast.makeText(HomeActivity.this, "Currently logged in", Toast.LENGTH_SHORT).show();
            }


        }
    });