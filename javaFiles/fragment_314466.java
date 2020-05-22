class C extends B { 

    @override
    public void someMethodWasInClassA() {
        throw new UnsupportedOperationException("Meaningful message");
    }

}