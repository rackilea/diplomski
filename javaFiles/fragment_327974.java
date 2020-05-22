AuditReader reader = AuditReaderFactory.get(entityManager);
User user_rev1 = reader.find(User.class, user.getId(), 1);

List<Number> revNumbers = reader.getRevisions(User.class, user_rev1);
User user_previous = reader.find(User.class, user_rev1.getId(),
  revNumbers.get(revNumbers.size()-1));