public void put(String key, MyObject o) {
    map.merge(
        key, o,
        (v1, v2) -> {
            // Modify some internal components of v1
            // and some other objects related to v1
            return v2;
        }
    );
}