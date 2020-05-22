QueryExecution qexec = QueryExecutionFactory.create(query, input.getModel());
Throwable thrown = null;
try {
    // Some other code
    while (results.hasNext()) {
        // do something
    }
    return something;
}
catch (Throwable t) {
    thrown = t; // Remember we're handling an exception
    throw t;
}
finally {
    try {
        qexec.close();
    }
    catch (Throwable t) {
        if (thrown == null) {
            // Not handling an exception, we can rethrow
            throw t;
        }
        else {
            // Log it or something, you can't allow it to
            // throw because there's *already* an exception
            // being thrown and you'll hide it. This is why
            // Java 7 added Throwable#addSuppressed.
        }
    }
}