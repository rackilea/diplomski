public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        Intent intent = new Intent(MainActivity.this, SpinnerActivity.class);
        intent.putExtra("txt", pos + 1);
        startActivity(intent);
    }