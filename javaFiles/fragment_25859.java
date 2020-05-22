public void onClick(View v) {
    if (v == viewcam)
      {
        Log.i("login", login.getText().toString());
        Log.i("Passwd", passwd.getText().toString());
        Intent localIntent1 = new Intent(v.getContext(), MjpegSample.class);
        Log.i("My ip", editTextIp.getText().toString());
        localIntent1.putExtra("ip", "http://" + editTextIp.getText().toString() + "/");
        localIntent1.putExtra("user", login.getText().toString());
        localIntent1.putExtra("passwd", passwd.getText().toString());
        startActivityForResult(localIntent1, 1000);
      }
    }