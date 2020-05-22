void test() {
    do_something();          // Not covered
    try {
       something_fixable();  // Covered
    } catch (InvalidStateException ex) {
       do_recovery_for_fixable_thing();
    }
}