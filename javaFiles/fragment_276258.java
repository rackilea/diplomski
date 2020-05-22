if (r.source instanceof VMemRef.Global) {
    VMemRef.Global source = (VMemRef.Global) r.source;
    // access fields specific to VMemRef.Global
} else if (r.source instanceof VMemRef.Stack) {
    VMemRef.Stack source = (VMemRef.Stack) r.source;
    // access fields specific to VMemRef.Stack
}