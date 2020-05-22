public void foo(String bar) {
    Preconditions.checkNotNull(bar);
    // here, you're sure that bar is not null. 
    // No need to use another variable or to reassign bar to the result 
    // of checkNotNull()
}