...
} catch (FileNotFoundException fnfe) {
    // ... handle FileNotFoundException
} catch (IOException e) {
    String exceptionSimpleName = e.getCause().getClass().getSimpleName();
    if ("ClientAbortException".equals(exceptionSimpleName)) {
        // ... handle ClientAbortException
    } else {
        // ... handle general IOException or another cause
    }
}
return null;