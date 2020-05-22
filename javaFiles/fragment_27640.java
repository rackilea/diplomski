Directory dir = null;
try {
    dir = new RAMDirectory();
    // use dir here, it will be automatically closed in the finally block.
} finally {
    if (dir != null) {
        dir.close(); // exception catching omitted
    }
}