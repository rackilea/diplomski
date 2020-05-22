class Interface1I2Adapter implements Interface2 {
    Interface1 i1;
    public Interface1I2Adapter (Interface1 i1) {
         this.i1 = i1;
    }
    // impl of Interface2 methods by delegating to i1
}