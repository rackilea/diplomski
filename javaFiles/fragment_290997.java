public abstract class Payload {

    // common fields and methods

    public abstract void accept(PayloadVisitor visitor);
}