TableNameClass tnc = new TableNameClass();
tnc.setName("Solution");
Session s = HibernateUtil.getSessionFactory().openSession();
Transaction t = s.beginTransaction();
Integer myID = (Integer)s.save(tnc);
t.commit();
s.close();
System.out.println(myID);