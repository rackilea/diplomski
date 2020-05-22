return Optional.ofNullable(
        switch (methodStr.strip().toUpperCase(Locale.ROOT)) {
            case "GET" -> RequestMethod.GET;
            // ... rest omitted

            default -> {
                log.warn("Unsupported request method: '{}'", methodStr);
                // break instead of return
                break null;
            }
        });