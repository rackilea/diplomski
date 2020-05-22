public void insert() {
    Login login = new Login();
    login.setUsername("test");
    login.setPassword("12345");
    login.setLanguage("english");

    Other other = new Other();
    other.setSessionID("111111");

    Hashtable<String, Login> loginHashTable = new Hashtable<String, Login>();
    loginHashTable.put("login", login);

    Hashtable<String, Other> otherHashTable = new Hashtable<String, Other>();
    otherHashTable.put("other", other);

    DBObject obj = new BasicDBObject();
    obj.put("HashTable1", loginHashTable);
    obj.put("HashTable2", otherHashTable);
    coll.insert(obj);
}

public void find() {
    DBObject query = new BasicDBObject();
    DBCursor cur = coll.find(query);

    for (DBObject obj : cur) {
        HashMap<String, Login> loginHashMap = (HashMap<String, Login>) obj.get("HashTable1");
        Hashtable<String, Login> loginHashTable = new Hashtable<String, Login>();
        loginHashTable.putAll(loginHashMap);

        HashMap<String, Other> otherHashMap = (HashMap<String, Other>) obj.get("HashTable2");
        Hashtable<String, Other> otherHashTable = new Hashtable<String, Other>();
        otherHashTable.putAll(otherHashMap);
    }
}