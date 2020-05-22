Session s = HibernateUtil.getSessionFactory().openSession();
Person p = (Person) s.get(Person.class, 1);
s.close();

System.out.println(p.getName());
System.out.println(p.getEmails());