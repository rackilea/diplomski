@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1001 && resultCode == Activity.RESULT_OK) {
            String myData = data.getStringExtra("my_key");
        }
    }