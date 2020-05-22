class CustomType {

    public boolean isEquivalent(CustomType ct) {
        return true; // TODO: Implement this
    }

    @Override
    public boolean equals(Object obj) {
        // TODO: Implement this
        if (obj instanceof CustomType) {
            return this.isEquivalent((CustomType) obj); 
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode(); // TODO: Implement this
    }
}

public static void main(String args[]) {
    List<CustomType> lst = new ArrayList<CustomType>();
    // use indexOf like normal
}