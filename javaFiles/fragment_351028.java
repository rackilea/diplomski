// given we don't know if autoSet contains a BstSetKTUx instance or not
if(autoSet instanceof BstSetKTUx) {
    // we can cast to BstSetKTUx without any problems
    autoSetBst = (BstSetKTUx<Automobilis>) autoSet;
} else {
    // autoSet does not contain an instance of BstSetKTUx
}