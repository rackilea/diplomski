x.callVisitor(new PaymentVisitor() {
    @Override void handleOneTimePayment(OneTimePayment payment) {
        // Code
    }
    @Override void handleSubscription(Subscription payment) {
        // Code
    }
});