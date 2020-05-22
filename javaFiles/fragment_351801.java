} catch (NotAnInt e) {
    inCommon1(e);
    // handle NotAnInt
    inCommon2(e);
} catch (ParseError e) {
    inCommon1(e);
    // handle ParseError
    inCommon2(e);
}

private void inCommon1(e) {
    // several steps
    // in common to
    // both cases
}
private void inCommon2(e) {
    // potentially several more
    // steps in common
    // to both cases
}