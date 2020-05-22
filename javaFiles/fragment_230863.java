for(final String s : array) {
    for(final Map.Entry<String, Runnable> entry : lookup) {
        if (s.contains(entry.getKey())) {
            entry.getValue().run();
            break;
        }
    }
}