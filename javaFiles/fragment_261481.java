public enum WrappedInvoiceStatus {
    DRAFT(InvoiceStatus.DRAFT, this::someAction),
    // other values 

    private WrappedInvoiceStatus(InvoiceStatus status, Action action) {
        this.status = status;
        this.action = action;
    }

    private interface Action { // can be one of Java default functional interfaces as well
        void doSomething(InputMessage msg);
    }

    private void someAction(InputMessage msg) {
        // behavior 
    }

    // some plumbing required 
}