// Hide the constructor
private Or(...) {
    ...
}
// Publish factory methods
public static <X> Or OrWithA(X a) {
    return new Or(...);
}
public static <X> Or OrWithB(X a) {
    return new Or(...);
}