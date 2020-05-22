try {
    whatever();
} catch (Exception e) {
    handleException(e);
} catch (NullPointerException e) {
    // This block is unreachable, because a NullPointerException is an
    // Exception and will thus be handled by the previous catch block.
    handleNpe(e);
}