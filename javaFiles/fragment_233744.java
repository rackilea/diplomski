final Dialog dialog=new Dialog(FirstActivity.this);
  dialog.setCancelable(false);
  dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
  dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
  dialog.setContentView(R.layout.dialog_custom);
  TextView cancel_btn=dialog.findViewById(R.id.cancel_btn);
  cancel_btn.setOnClickListener(new View.OnClickListener(){
     @Override
     public void onClick(View view){
        dialog.dismiss();
     }
  });
  TextView ok_btn=dialog.findViewById(R.id.ok_btn);
  ok_btn.setOnClickListener(new View.OnClickListener(){
     @Override
     public void onClick(View view){
        dialog.dismiss();

     }
  });
  dialog.show();