Entry entry = new Entry();
entry.setCardNumber(123);
entry.setCompanyId(3);
entry = session.merge(entry);   

session.flush();
session.refresh(entry );