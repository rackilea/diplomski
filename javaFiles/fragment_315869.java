try {
    Path path = file.toPath();

    AclFileAttributeView aclView = Files.getFileAttributeView(path, AclFileAttributeView.class);
    if(aclView == null)
    {
        System.out.format("ACL View not supported");
    }

    UserPrincipal up = FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName("username");
    Set<AclEntryPermission> aep = EnumSet.of(READ_DATA,WRITE_DATA);

    AclEntry builder = AclEntry.newBuilder().setType(AclEntryType.ALLOW).
            setPrincipal(up).setPermissions(aep).build();

    List<AclEntry> acl = aclView.getAcl();
    acl.add(0,builder);
    aclView.setAcl(acl);
} catch (IOException ex) {
    Logger.getLogger(PermissionsUtil.class.getName()).log(Level.SEVERE, null, ex);
}