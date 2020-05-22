//check if user in null
if (firebaseUser != null){
    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
    startActivity(intent);
    finish();
}