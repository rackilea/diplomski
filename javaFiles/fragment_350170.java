for (int e = 0; e < effective.size(); e++) {
    for (int r = 0; r < resist.size(); r++) {
        if (effective.get(e).equals(resist.get(r))) {
            effective.remove(e);
            resist.remove(r);
            e--;
            break;
        }
    }
}