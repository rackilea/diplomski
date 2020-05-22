if (id == android.R.id.home){
    Toast.makeText(getApplicationContext(), "Saving User Info", Toast.LENGTH_SHORT).show();
    String[] userArray = getIntent().getExtras().getStringArray("userArray");
    Log.d("Returning user data:", Arrays.toString(userArray));
    Intent intent = new Intent();
    intent.putExtra("userArray", userArray);
    setResult(RESULT_OK, intent);
    finish();
    return true;
}