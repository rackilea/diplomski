new Button.OnClickListener() {
      public void onClick(View v) {
         Intent intent = new Intent(v.getContext(), secondPage.class);
         startActivity(intent);

         yourExistingActivity.finish();  // This will free the memory

}