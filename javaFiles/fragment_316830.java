float x = ...
    if (x >= 0.0F && x < 0.5F) {
        // between 0.0 (inclusive) and 0.5 (exclusive)
    } else if (x >= 0.5F && x < 1.0F) {
        // between 0.5 (inclusive) and 1.0 (exclusive)
    } else if (x >= 1.0F && x < 1.5F) {
        // between 1.0 (inclusive) and 1.5 (exclusive)
    } else if (x >= 1.5F && x <= 2.0F) {
        // between 1.5 (inclusive) and 2.0 (inclusive)
    } else {
        // out of range
    }