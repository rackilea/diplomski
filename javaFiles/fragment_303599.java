public boolean save(AccountManager manager) {
    removeAll(manager);
    boolean result = manager.addAccountExplicitly(this, null, toBundle());
    manager.setAuthToken(this, KEY_1, value1);
    manager.setAuthToken(this, KEY_2, value2);
    manager.setAuthToken(this, KEY_3, value3);
    return result;
}