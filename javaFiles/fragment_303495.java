@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Add this line
        super.onActivityResult(requestCode, resultCode, data);

        // This all remains the same
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                MyCustomDialogFragment newPopup = new MyCustomDialogFragment();
                newPopup.setMyClickListener(MainActivity.this);
                FragmentManager fragmentManager = getSupportFragmentManager();
                newPopup.show(fragmentManager, "CashReceivePopup");  
          } 
       }
   }