public void xxxxx() {
    try {
        throw new IOException(); //or anything that have declared checked exception
    } catch (Exception e) {
        throw e;
    }
}