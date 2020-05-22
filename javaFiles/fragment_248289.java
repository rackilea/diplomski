try (CallableStatement stmt = con.prepareCall("...")) {
    boolean results = stmt.execute();

    for (;;) {
        if (results)
            try (ResultSet rs = stmt.getResultSet()) {
                // ... Fetch your results here
            }
        else if (stmt.getUpdateCount() != -1) {}
        else
            break;

        results = stmt.getMoreResults();
    }

    // After all results are fetched, you can also retrieve OUT parameters, if applicable
}