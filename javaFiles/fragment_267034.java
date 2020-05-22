Intent intent = new Intent(MainActivity.this, JsonFormActivity.class);
if (json != null) {
 intent.putExtra("json", json);
 startActivityForResult(intent, REQUEST_CODE_GET_JSON);
} else {
 Toast.makeText(getApplicationContext(), "Error!!", Toast.LENGTH_LONG).show();
}
}