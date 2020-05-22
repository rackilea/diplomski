Pair max = new Pair();
for (Pair p : values) {
    if (p.max().get() > max.max.get()) {
        max.set(p);
    }
}
context.write(key, max);