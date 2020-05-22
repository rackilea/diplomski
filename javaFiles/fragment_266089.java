private void mergeStackTraces(Throwable error)
    {
        StackTraceElement[] currentStack =
            new Throwable().getStackTrace();
        int currentStackLimit = 4; // TODO: raussuchen

        // We simply cut off the top 4 elements, which is just 
        // right for our framework. A more stable solution
        // would be to filter by class name or such.

        StackTraceElement[] oldStack =
            error.getStackTrace();
        StackTraceElement[] zusammen =
            new StackTraceElement[currentStack.length - currentStackLimit +
                                  oldStack.length + 1];
        System.arraycopy(oldStack, 0, zusammen, 0, oldStack.length);
        zusammen[oldStack.length] =
            new StackTraceElement("══════════════════════════",
                                  "<remote call %" +callID+ ">",
                                  "", -3);
        System.arraycopy(currentStack, currentStackLimit,
                         zusammen, oldStack.length+1,
                         currentStack.length - currentStackLimit);
        error.setStackTrace(zusammen);
    }