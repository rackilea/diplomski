onScrolled() {
    synchronized(this) {
        if(!ready)
            return;
        else
            ready = false;
    }

    // your current onScroll body
}