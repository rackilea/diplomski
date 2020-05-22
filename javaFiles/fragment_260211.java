InvInTc invIn = new InvInTc();
invIn.setInvInTcKey("1234");
invIn.setInvInTcQty(1);
invInTc1.add(invIn);

InvInTc invIn2 = new InvInTc();
// Copy the key from one object to the other
invIn2.setInvInTcKey(invIn.getInvTcKey());
// But set a different quantity
invIn2.setInvInTcQty(5);
invInTc2.add(invIn);