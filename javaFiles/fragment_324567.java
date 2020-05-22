private volatile Map<String,HashMap> myStuff_ = new HashMap<String,HashMap>();

public HashMap getter(String a) {
    return myStuff_.get(a);
}

public synchronized void setter() {
    // create a copy from the original
    Map<String,HashMap> copy = new HashMap<String,HashMap>(myStuff_);
    // populate the copy
    // replace copy with the original
    myStuff_ = copy;
}