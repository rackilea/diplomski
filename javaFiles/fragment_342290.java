for (Future<Map<String, List<Offset>>> f : listFutures) {
        Map<String, List<Offset>> inner = f.get();
        for (Entry<String, List<Offset>> e : inner.entrySet()) {
            results.merge(e.getKey(), e.getValue(), (left, right) -> {
                left.addAll(right);
                return left;
            });
        }
    }