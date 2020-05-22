public class Currency {

    ...

    @Override
    public String toString() {
        //overriden in a custom way
    }

    @Override
    public boolean equals(Object other) {
        if(other instanceof Currency) {
            Currency that = (Currency) other;
            return this.toString().equals(that.toString());
        }
        return false;
    }

    ...
}