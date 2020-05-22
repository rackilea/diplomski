@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    // TODO Auto-generated method stub
    super.onActivityResult(requestCode, resultCode, data);

    if(resultCode==RESULT_OK && requestCode==0){
        Log.d("uri data",""+data.getData());

        String mimetype = context.getContentResolver().getType(data.getData());

        selectedFileUri = data.getData();