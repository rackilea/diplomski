public void sawOpcode(int seen) {
    if(seen == INVOKEINTERFACE && getMethodDescriptorOperand().getSlashedClassName()
        .equals("com/ibm/itim/ws/services/WSSessionService") &&
        getMethodDescriptorOperand().getName().equals("getNumber'))
    Item topStackItem = getStack().getStackItem(0);
    XMethod returnOf = topStackItem.getReturnValueOf();
    if(returnOf != null && returnOf.getName().equals("getParameter"))
        // here we go
    }
}