int customerId = 1;
Session session = HibernateUtil.getSessionFactory().openSession();
Transaction tr = session.beginTransaction();
PurchaseOrder o = new PurchaseOrder();
o.setFreightCompany("Companytest");
o.setCustomerId(customerId);
                session.save(o);
                tr.commit();