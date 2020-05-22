sName4.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View view) {
      if (sName3.isChecked()){
         sName3.setChecked(false);
         sName3.setTextColor(Color.parseColor("#17fc6b")); // set your color
      }else{
         sName3.setChecked(true);
         sName3.setTextColor(Color.parseColor("#178DFC"));
      }
}});