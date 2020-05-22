try {
    // code that can throw exceptions...
} catch ( Exception1 | Exception2 | ExceptionN exc ) {
    // you can handle Exception1, 2 and N in the same way here
} catch ( Exception exc ) {
    // here you handle the rest
}