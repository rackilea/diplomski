public void doSomething(Set<String> emails){
        CompletableFuture.allOf(emails.stream()
                .map(email -> yourService.doAsync(email)
                        .exceptionally(e -> {
                            LOG.error(e.getMessage(), e);
                            return null;
                        })
                        .thenAccept(longResult -> /*do something with result if needed */))
                .toArray(CompletableFuture<?>[]::new))
            .join();
    }