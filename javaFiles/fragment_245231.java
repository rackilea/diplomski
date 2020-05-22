public void addUserToGroup(LdapContext ctx, String userDN, String groupDN)
    throws NamingException {
    ModificationItem[] mods = new ModificationItem[1];
    mods[0] = new ModificationItem(DirContext.ADD_ATTRIBUTE,
            new BasicAttribute("member", userDN));

    ctx.modifyAttributes(groupDN, mods);
}

public void removeUserFromGroup(LdapContext ctx, String userDN,
    String groupDN) throws NamingException {
    ModificationItem[] mods = new ModificationItem[1];
    mods[0] = new ModificationItem(DirContext.REMOVE_ATTRIBUTE,
            new BasicAttribute("member", userDN));

    ctx.modifyAttributes(groupDN, mods);
}