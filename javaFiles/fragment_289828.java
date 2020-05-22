AclEntry entry = new AclEntry();
entry.setScope(new AclScope(AclScope.Type.USER, "jdoe@gmail.com"));
entry.setRole(CalendarAclRole.READ);

URL aclUrl =
  new URL("http://www.google.com/calendar/feeds/jo@gmail.com/acl/full");

AclEntry insertedEntry = service.insert(aclUrl, entry);