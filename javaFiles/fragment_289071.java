void findEntry(LdapConnection connection, Entry entry, StringBuilder sb)
    throws LdapException, CursorException {
  sb.append(LdifUtils.convertToLdif(entry));
  sb.append("\n");
  EntryCursor cursor = connection.search(entry.getDn(), "(ObjectClass=*)", SearchScope.ONELEVEL, "*", "+");
  while (cursor.next()) {
    findEntry(connection, cursor.get(), sb);
  }
}