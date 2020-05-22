MDC.put("system", "fedora");
try {
    // your code here
} finally {
    MDC.remove("system");
}