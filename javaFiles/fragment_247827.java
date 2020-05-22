public DemoChainResponsibilityPattern1() {
    c1 = new Dollar50Dispenser();
    DispenseChain c2 = new Dollar20Dispenser();
    DispenseChain c3 = new Dollar10Dispenser();
    //set the the chain of responsibility
    c1.setNextChain(c2);
    c2.setNextChain(c3);
}