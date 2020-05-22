public void onClick3Activity(View v){
            Intent i = new Intent();
            i.setClass(2Activity.this, 3Activity.class);
            startActivityForResult(i, 1);
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==726){
            Intent in = new Intent();
            in.putExtra("test", "test");
            setResult(726,in);
            finish();
        }
        else{
            Log.v("Failed", "Failed");
        }
    }