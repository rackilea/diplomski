class RegularCustomer extends Customer {
    public int getPrice() {
        return 100;
    }
}

class HandicappedCustomer extends Customer {
    public int getPrice() {
        return 0;
    }
}