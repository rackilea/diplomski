private void submitActionPerformed(java.awt.event.ActionEvent evt) {     

    boolean validEntries = true;
    String sVal;
    int iVal;
    Bidder bidder2 = new Bidder();

    sVal = userName.getText();
    if (sVal.equals(""))
    {
        validEntries = false;
        userName.setBackground(Color.red);
    } else {
        bidder2.setUserName(sVal);
    }
    sVal = password.getText();
    if (sVal.equals(""))
    {
        validEntries = false;
        password.setBackground(Color.red);
    } else {
        bidder2.setUserPassword(sVal);
    }

    // for an int value:
    try{
        iVal = Integer.parseInt(csv.getText());
        bidder2.setCSV(iVal);
    }
    catch (Exception error)
    {
        validEntries = false;
        userType.setBackground(Color.red);
    }

    // etc. for all the other fields

    if (validEntries) {
        Bidder.BidderArray.add(bidder2);
    }
}