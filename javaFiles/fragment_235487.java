SomeResource r1 = null;
Throwable thrown = null;
try {
    r1 = new SomeResource();

    SomeOtherResource r2 = null;
    try {
        r2 = new SomeOtherResource();
        // use them
        return something;
    }
    catch (Throwable t) {
        thrown = t; // Remember we're handling an exception
        throw t;
    }
    finally {
        try {
            r2.close();
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
}
catch (Throwable t) {
    thrown = t; // Remember we're handling an exception
    throw t;
}
finally {
    try {
        r1.close();
    }
    catch (Throwable t) {
        if (thrown == null) {
            // Not handling an exception, we can rethrow
            throw t;
        }
        else {
            // Log it or something
        }
    }
}