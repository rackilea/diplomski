if(!accountstorage.exists()) {
    accountstorage.getParentFile().mkdirs();
    accountstorage.createNewFile();
} else {
    return; // DUE to this... Remove else block to fix.
}