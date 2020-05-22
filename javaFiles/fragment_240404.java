String name = A.value1.name();

try {
    B b = B.valueOf(name);
}
catch (IllegalArgumentException e) {
    // Handle this if name doesn't exist in B
}