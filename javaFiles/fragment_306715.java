try {
    // main loop
    businessLogic();
} catch (OutOfMemoryError E) {
    System.exit(1);
}