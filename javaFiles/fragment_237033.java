// lookup "joe"
 UserPrincipal joe = file.getFileSystem().getUserPrincipalLookupService()
     .lookupPrincipalByName("joe");

 // get view
 AclFileAttributeView view = Files.getFileAttributeView(file, AclFileAttributeView.class);

 // create ACE to give "joe" read access
 AclEntry entry = AclEntry.newBuilder()
     .setType(AclEntryType.ALLOW)
     .setPrincipal(joe)
     .setPermissions(AclEntryPermission.READ_DATA, AclEntryPermission.READ_ATTRIBUTES)
     .build();

 // read ACL, insert ACE, re-write ACL
 List<AclEntry> acl = view.getAcl();
 acl.add(0, entry);   // insert before any DENY entries
 view.setAcl(acl);