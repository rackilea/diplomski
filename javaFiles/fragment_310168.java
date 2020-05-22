for(int i = 0; i < holdings.length; i++) {
  if (holdings[i].holdingID.equals(userHoldingIDInput)) {
    // ...
    return;
  }
}
System.out.println("The Holding ID you entered was not found,"
                        + " please try again." + "\n");
return;  // Might be unnecessary; depends upon what follows.