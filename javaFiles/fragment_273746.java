boolean asserted = false;

try {
   assert false;
} catch (AssertionError e) {
   asserted = true;
}

if (!asserted) {
    System.err.println("Missing '-ea' flag; exiting.");
    System.exit(1);
    // ... or throw a RuntimeException, depending on your environment.
}