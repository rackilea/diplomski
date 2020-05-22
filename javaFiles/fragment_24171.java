LdapName ldapName = new LdapName(dn);
 List<Rdn>  distinguishedNames = ldapName.getRdns();

 for (Rdn rdn : distinguishedNames) {
     if ("c".equals(name.getType().toLowerCase())) {
         country = (String) name.getValue();
     }
     ...
 }