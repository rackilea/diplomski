void update(Collection<String> values, Updater updater) {
    update(values, updater::update, 0);
}
void update(Collection<String> values, Consumer<String> fn, int ignored) {
    // some code
}