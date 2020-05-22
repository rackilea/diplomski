public void foo() {
    int i = 1;
    { 
        int j = 2;
    }
    // Can't refer to the "j" declared here.  But can declare a new one.
    int j = 3;
}