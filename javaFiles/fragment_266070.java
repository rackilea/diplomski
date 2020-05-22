protected abstract T self();

    public T setPrice(double price)  {
        Stuff.this.price = price;
        return (T) self();
    }