@Test
public void testSaveBill(){
    //Success
    IBill bill = factory.getBillInfo();
    Bill nanny = new Bill("Nanny",128d,new Date(6/28/2013),"Montly");
    assertTrue(bill.save(nanny));

   //Failure
   assertFalse(bill.save(null));
}