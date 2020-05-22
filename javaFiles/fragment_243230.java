private Handler handler = new Handler() {
    @Override
    public void handleMessage(Message msg) {
        appcounter++;
        if (appcounter < fnames.length) { 
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(new File(appsPath + "/" + fnames[appcounter])), "application/vnd.android.package-archive");
        startActivityForResult(intent, req);  
        }
    }
};

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
      Log.d("CheckStartActivity","onActivityResult and resultCode = "+resultCode);
      // TODO Auto-generated method stub
      super.onActivityResult(requestCode, resultCode, data);
   //  appcounter++; 
    handler.sendEmptyMessage(0);


  }