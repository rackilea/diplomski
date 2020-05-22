public void setAddress(Set<Address> address) {

        for (Address child : address) {
            // initializing the TestObj instance in Children class (Owner side)
            // so that it is not a null and PK can be created
            child.setCustomer(this);
        }
        this.address = address;
    }