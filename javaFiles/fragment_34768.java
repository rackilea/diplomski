class OneTimePayment {
    ...
    @Override void callVisitor(PaymentVisitor visitor) {
        visitor.handleOneTimePayment(this);
    }
}

class Subscription {
    ...
    @Override void callVisitor(PaymentVisitor visitor) {
        visitor.handleSubscription(this);
    }
}