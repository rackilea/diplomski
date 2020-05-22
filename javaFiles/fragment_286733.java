public void takeOverTheWorld() {
    if(this.foo instanceof Bar)
        doBarFoo();
}

private <T extends Foo & Bar> void doBarFoo() {
    Foo.doFoo((T)this.foo);
}