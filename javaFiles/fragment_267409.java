try {
    MDC.put("Id", UUID.randomUUID().toString());

    // The rest of your code
} finally {
    MDC.remove("Id");
}