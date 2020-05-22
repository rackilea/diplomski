/* Start Activity */ public void onClick(View v) {
    Intent intent = new Intent(Intent.ACTION_VIEW);
    intent.setClassName("com.thinoo.ActivityTest", "com.thinoo.ActivityTest.NewActivity");
    startActivityForResult(intent,90); } /* Called when the second activity's finished */ protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    switch(requestCode) {
    case 90:
        if (resultCode == RESULT_OK) {
            Bundle res = data.getExtras();
            String result = res.getString("param_result");
            Log.d("FIRST", "result:"+result);
        }
        break;
    } }

private void finishWithResult() {
    Bundle conData = new Bundle();
    conData.putString("param_result", "Thanks Thanks");
    Intent intent = new Intent();
    intent.putExtras(conData);
    setResult(RESULT_OK, intent);
    finish(); }