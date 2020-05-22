public static void main(String[] args) {
    // Test for target in middle:
    System.out.println(deleteLastOccurrence("foo,bar,dog,cat,dog,bird,dog", "dog"));
    // Test for target at start:
    System.out.println(deleteLastOccurrence("dog,bar,dog,cat,dog,bird,dog", "dog"));
    // Test for target at end:
    System.out.println(deleteLastOccurrence("foo,bar,cat,bird,dog", "dog"));
}