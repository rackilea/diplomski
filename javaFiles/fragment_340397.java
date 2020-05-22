public Acl readAclById(ObjectIdentity objectIdentity, List<Sid> sids) throws NotFoundException {
    /*
examines objectIdentity which identifies domain object in question, and sids which identifies the principal who wants permissions on the domain object, then returns an ACL instance with permission grants on that domain object for that/those principals
    */
    return new AclImpl(...);
}