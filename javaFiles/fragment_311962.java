void outerMethod() {
    // ...        
    // ...

    // Beginning of legal usage scope of the local class
    class Inner {
        void innerMethod() {
            System.out.println("inner class method...");
        }
    }
    // ...
    // ...
    // End of legal usage scope of the local class
}