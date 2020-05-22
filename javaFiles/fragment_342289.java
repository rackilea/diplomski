listFutures.stream()
            .map(x -> {
                try {
                    return x.get();
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            })
            .flatMap(x -> x.entrySet().stream())
            .collect(Collectors.toMap(
                    Entry::getKey,
                    Entry::getValue,
                    (left, right) -> {
                        left.addAll(right);
                        return left;
                    }));