public static ArrayList<String> getUsersByManager(String manager) throws NamingException {
    String baseDN = "ou=Internal,ou=People,o=group";
    ArrayList<String> list = new ArrayList<String>();
    SearchControls sc = new SearchControls();
    String[] attributeFilter = { "uid" };
    sc.setReturningAttributes(attributeFilter);
    sc.setSearchScope(SearchControls.SUBTREE_SCOPE);
    String filter = "(&(manager=uid=" + manager + ",ou=Internal,ou=People,o=Group))";
    DirContext contexte = Connexion();
    NamingEnumeration results = contexte.search(baseDN, filter, sc);
    while (results.hasMore()) {
        SearchResult sr = (SearchResult) results.next();
        Attributes attrs = sr.getAttributes();
        String user = attrs.get("uid").get().toString();
        list.add(user);
        // recursive call:
        ArrayList<String> usersManaged = getUsersByManager(user);
        list.addAll(usersManaged);
    }
    contexte.close();
    return list;
}