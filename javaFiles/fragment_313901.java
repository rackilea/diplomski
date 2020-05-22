private boolean reloadParent;

public void submit() {
    // ...
    reloadParent = true;
}

public boolean isReloadParent() {
    return reloadParent;
}