public final class PayloadA extends Payload {

    // ...

    @Override
    public void accept(PayloadVisitor visitor) {
        visitor.visit(this);
    }
}

public final class PayloadB extends Payload {

    // ...

    @Override
    public void accept(PayloadVisitor visitor) {
        visitor.visit(this);
    }
}