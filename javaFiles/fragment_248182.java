private void logOut() {
FirebaseAuth.getInstance().signOut();
Intent i=new Intent(getApplicationContext(),LoginActivity.class);
startActivity(i);

}