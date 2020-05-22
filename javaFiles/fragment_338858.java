SessionFactory factory=cfg.buildSessionFactory();  
Session session=factory.openSession();  
Transaction t=session.beginTransaction();  
Economy e= (Economy) session.get(Economy.class, part_no ....);
t.commit();
session.close();  
return e.getData();