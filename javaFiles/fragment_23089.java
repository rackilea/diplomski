class Pizza {
private int size;
private boolean cheese;
private boolean pepperoni;
private boolean bacon;

public static class Builder {
    private Pizza pizza = new Pizza();

    public Builder(int size) {
        pizza.size = size;
    }

    public Builder cheese(boolean value) {
        pizza.cheese = value;
        return this;
    }

    public Builder pepperoni(boolean value) {
        pizza.pepperoni = value;
        return this;
    }

    public Builder bacon(boolean value) {
        pizza.bacon = value;
        return this;
    }

    public Pizza build() {
        return pizza;
    }
}

private Pizza() {
}
}