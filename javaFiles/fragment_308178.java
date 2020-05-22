public void createId() {
    Customer cust = findCustomer(this.custId);
    Address addr = findAddress(this.addr);

    UniqueIdCreator create = makeIdCreator();
    this.name.setName(create.customerName.getName());
}

protected UniqueIdCreator makeIdCreator() {
    UniqueIdCreator create = new UniqueIdCreator(
        this.custId, this.addr, this.name);
    create.populate();
    return create;
}