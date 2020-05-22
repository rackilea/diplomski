class Example implements OuterInterface,OuterInterface.InnerInterface {

    public void InnerInerfaceMethod() {
        System.out.println("inner method called");
    }

    public InnerInterface GetInnerInterfaceReference() {
        return this; 
    }
}