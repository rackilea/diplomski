firebaseAuth.signInWithEmailAndPassword(email, password)
    .addOnCompleteListener(this, task -> {
         if (task.isSuccessful()) {
             Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
             startActivity(mainActivity);
             finish();
         }
    });