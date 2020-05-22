public void onClick2Activity(View v){
            Intent i = new Intent();
            i.setClass(1Activity.this, 2Activity.class);
            startActivityForResult(i, 0);
        }

@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==726){
            Bundle bundle = data.getExtras();
            int string = bundle.getInt("test");
            Log.v("Extra", "" + string);
            Toast.makeText(this, "Pass", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Fail", Toast.LENGTH_LONG).show();
        }
    }