String str = null;

try {
    ...
    str = "condition2";
} catch (ApplicationException|IllegalStateException|Exception ex) {
    str = "condition3";
}