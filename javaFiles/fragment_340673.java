public final void doTransfer() {
    // protected methods since we want to enforce this order of execution
    download(); // implem provided
    process(); // abstract method
    upload(); // implem provided
}
protected final void download() {
    // implementation provided
}

protected abstract void process(); // implementation not provided

protected final void upload() {
    // implementation provided
}