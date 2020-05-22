{
    SomeResource someResource = null;
    Throwable primaryException = null;

    try {
        someResource = /*...get the resource...*/;
        /*...do something...*/
    }
    catch (Throwable t) {
        primaryException = t;
        throw t;
    }
    finally {
        if (someResource != null) {
            if (primaryException != null) {
                // Dealing with a primary exception, close the resource
                // and suppress any exception resulting
                try {
                    someResource.close();
                }
                catch (Throwable suppressed) {
                    primaryException.addSuppressed(suppressed);
                }
            }
            else {
                // Not dealing with a primary exception, close the
                // resource without suppressing any resulting exception
                someResource.close();
            }
        }
    }
}