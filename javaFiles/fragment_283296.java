protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == 123 && resultCode == RESULT_OK) {
        //do some stuff...
    } else {
        super.onActivityResult(requestCode, resultCode, data);
    }
}