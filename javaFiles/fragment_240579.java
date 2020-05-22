...

private boolean executeSearch(Runnable... commands)
{
    for (Runnable cmd : commands) {
        if (isFoundAfter(cmd)) return true;
    }
    return false; //didn't find what it was looking for
}

public boolean search() {
    return executeSearch(going, spinning /* around 8 more similar commands */);
}