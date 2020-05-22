String add = request.getParameter("Id");
        Session session1 = hiber.getSessionFactory().getCurrentSession();   
        Transaction tx; 
        try {
            tx = session1.beginTransaction();
            for (Iterator<House> iterator = SessionUser.gethouse().iterator(); iterator.hasNext();) {
                House house = iterator.next();
                if (house.getProjectId() == Long.parseLong(add)) {
                    iterator.remove();
                    session1.remove(house);
                    session1.flush();
                }
            }

            session1.merge(SessionUser);
            tx.commit();    

        } catch (Exception e) {
            System.out.println(e);
        } finally {         
            System.out.println("______");
            session1.close();
        }