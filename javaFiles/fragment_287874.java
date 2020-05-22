boolean DNmatches(X500Principal p1, X500Principal p2) {
    List<Rdn> rdn1 = new LdapName(p1.getName()).getRdns();
    List<Rdn> rdn2 = new LdapName(p2.getName()).getRdns();

    if(rdn1.size() != rdn2.size())
        return false;

    return rdn1.containsAll(rdn2);
}