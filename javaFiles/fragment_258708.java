try {
      Subject subject = (Subject) PolicyContext.getContext("javax.security.auth.Subject.container");
      Set<Group> subjectGroups = subject.getPrincipals(Group.class);
      Iterator<Group> iter = subjectGroups.iterator();
      while (iter.hasNext()) {
        Group group = iter.next();
        String name = group.getName();
        if (name.equals("CallerPrincipal")) {
          Enumeration<? extends Principal> members = group.members();
          if (members.hasMoreElements()) {
            context = members.nextElement();
            myCustomPrincipal = (MyCustomPrincipal) context;
          }
        }
      }
    } catch (PolicyContextException e) {
        ....
    }