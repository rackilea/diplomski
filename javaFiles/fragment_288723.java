public void refreshFields()
  { 
    Account theAccount = new Account();
    aitf.setText(theAccount.getId());
    abtf.setText(theAccount.getBalace());
    // diplays accound id and balance in left text fields
    //should be called when the applet is first displayed and after each valid transaction
  }