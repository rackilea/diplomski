try (ResultSet rs = cs.executeQuery()) {
    while (rs.next()) {
        res.add(new ImmutablePair<>(rs.getLong(1), rs.getString(2)));
    }

    // Process a batch of rows:
    if (res.size() >= 2000) {
        process(res);
        res.clear();
    }
}

// Process the remaining rows
process(res);