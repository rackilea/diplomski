double sum = x.values().stream().mapToDouble(y -> {
    try {
        return Double.parseDouble(y.get("myKey"));
    } catch (NumberFormatException e) {
        return 0.0;
    }
}).sum();