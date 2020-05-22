private void Logout(){
    firebaseAuth.signOut();
    Intent intent = new Intent(SecondActivity.this, MainActivity.class);
     intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                    | Intent.FLAG_ACTIVITY_CLEAR_TOP
                    | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
    finish();
}