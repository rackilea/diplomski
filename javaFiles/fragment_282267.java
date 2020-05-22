private static void unboundIdLdapSearch(final String ldapADServer, final String bindDN, final String bindCredential, final String baseCtxDN, final String userName) throws LDAPException, Exception {
    final LDAPConnection connection = new LDAPConnection(ldapADServer.substring(0, ldapADServer.indexOf(':')),
        Integer.parseInt(ldapADServer.substring(ldapADServer.indexOf(':') + 1)), bindDN, bindCredential);
    findAccountByAccountName(connection, baseCtxDN, userName);
    connection.close();
}

private static void findAccountByAccountName(final LDAPConnection connection, final String baseCtxDN, final String accountName) throws Exception {

    final String searchFilter = "(&(objectClass=user)(sAMAccountName=" + accountName + "))";

    logger.info("LDAP search filter: {}", searchFilter);

    final SearchRequest request = new SearchRequest(baseCtxDN, SearchScope.SUB, searchFilter);
    final com.unboundid.ldap.sdk.SearchResult result = connection.search(request);
    final int numOfResults = result.getEntryCount();
    final StringBuilder builder = new StringBuilder();
    builder.append("Search returned with ").append(numOfResults).append(" results: ").append(StringUtils.NEW_LINE);
    for (final SearchResultEntry entry : result.getSearchEntries()) {
        builder.append(LdapHelper.getSearchResultDetails(entry, ""));
    }

    logger.info("Search results: {}{}", StringUtils.NEW_LINE, builder.toString());
}