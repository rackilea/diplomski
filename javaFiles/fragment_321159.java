boolean successful = false;
try {
    // do stuff
    successful = true;
} catch (...) {
    ...
} finally {
    if (!successful) {
        // cleanup
    }
}