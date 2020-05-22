try {
    ...
} catch(...) {
} finally {
    writer.close(); // Closes and flushes out the remaining lines
}