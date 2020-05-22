listView.setOnItemLongClickListener(new OnItemLongClickListener(){ //function starts here
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view,
            int position, long id) { // longclick starts here
        final int finalPosition = position;
        PopupMenu popup = new PopupMenu(AddClaim.this, view); // your menu code starts here
        popup.getMenuInflater().inflate(R.menu.add_claim, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {  
            public boolean onMenuItemClick(MenuItem item) {  
            //DELETE button check.  
              if (item.getTitle().equals("Delete")){
                AlertDialog.Builder adb = new AlertDialog.Builder(AddClaim.this);
                adb.setMessage("Delete "+ list.get(finalPosition).toString()+"?");
                adb.setCancelable(true);
                adb.setPositiveButton("Delete",new OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Claim claim = list.get(finalPosition);
                        ClaimListController.getClaimList().deleteClaim(claim);
                    }
                });
                adb.setNegativeButton("Cancel",new OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {                        
                    }

                });
                adb.show();
              }//end of delete button check
              //START of ADD EXPENSE check
              if (item.getTitle().equals("Add Expense")){
                  Intent intent = new Intent(AddClaim.this, ExpenseAdd.class);
                  intent.putExtra("somename", finalPosition);
                  startActivity(intent);

                      }
              //end of add expense check
              return true;  // you only return true if onmenu item is clicked.. which is too late
             }  
            });  
        popup.show();  // and your menu code ends here, because this is where it is shown..
    return false; // you are returning false.. this is {star line}
    } //longclick ends here 

 }); //function ends here

}