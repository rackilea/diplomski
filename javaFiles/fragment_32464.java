return Optional.ofNullable(
        switch (methodStr.strip().toUpperCase(Locale.ROOT)) {
            case "GET" -> RequestMethod.GET;
            // ... rest omitted

            default -> {
                log.warn("Unsupported request method: '{}'", methodStr);
                // yield instead of return
                yield null;
            }
        });