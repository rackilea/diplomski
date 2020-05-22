stateOrProvinceName ATTRIBUTE ::= {
  SUBTYPE OF name
  WITH SYNTAX UnboundedDirectoryString
  LDAP-SYNTAX directoryString.&id
  LDAP-NAME {"st"}
  ID id-at-stateOrProvinceName }