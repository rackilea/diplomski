public abstract class Package {
    protected String description;  // These shouldn't be private fields instead of protected?
    protected String packagingCode; // Nah, I don't think so, otherwise how could I store a value into the Quantity field? =P 
    protected Dimension dimensions;  
    protected Weight weight;  
    protected int quantity;

    // Constructors, getters and setters...

    public virtual int getQuantity {
        throw new NotImplementedException();
    }

    public virtual int setQuantity(int quantity) {
        throw new NotImplementedException();
    }
}

public final class OrderQuantityPackage extends Package {
    public override int getQuantity {
        return super.quantity;
    }

    public override void setQuantity(int quantity) {
        super.quantity = quantity;
    }
}