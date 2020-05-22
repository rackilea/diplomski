Entry entry = new Entry();
entry.setCardNumber(123);

entry.setCompany(new Company());
entry.getCompany().setId(3);
session.persist(session);