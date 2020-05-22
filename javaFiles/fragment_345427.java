Optional<Combination> best = Optional.empty();
for (int amount1 = ...) {
    for (int amount2 = ...) {
        for (int amount3 = ...) {
            Combination combo = new Combination(amount1, amount2, amount3);
            int cost = combo.getCost();
            if (cost < limit && (best.isEmpty() || cost > best.get().getCost()))
                best = Optional.of(combo);
        }
    }
}