@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    if (requestCode == 100) {
        if(resultCode == Activity.RESULT_OK){
            String result=data.getStringExtra("result");
        }
    }
}