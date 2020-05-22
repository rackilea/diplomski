public List<Gensalarystructure> GensalarystructureList(){

    System.out.println("SalaryList");
    List<Gensalarystructure[]> salary = null;
    Transaction tx = null;
    Gensalarystructure ob =null;
    Session session = getSessionFactory().openSession();
    Query query = null;
    List<Gensalarystructure> list = new ArrayList<Gensalarystructure>();
    try {
        tx = session.beginTransaction();
            query = session.createQuery("SELECT distinct salaryNo,userId FROM Gensalarystructure");      
            salary = query.list();
            System.out.println("list salary "+salary);                
              for(Object[] objArr: salary){
                        ob=new Gensalarystructure();
                        ob.setStructureNo(((String)(objArr[0])));
                        ob.setStructureCode((String)(objArr[1]));

                        list.add(ob);

                    }   

        tx.commit();
    } catch (HibernateException e) {
        if (tx != null) {
            tx.rollback();
        }
        e.printStackTrace();
    }  finally {
        session.close();
    }

    return list;
}