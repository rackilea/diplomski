public static boolean contains(String test) {

    for (Choice c : Choice.values()) {
        if (c.name().equals(test)) {
            return true;
        }
    }

    return false;
}