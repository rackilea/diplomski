while (result.next()) {
    // This outer loop is executed once per row        

    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
        // This inner loop is executed once per column (per row, as it's
        // within the outer loop)
    }
}