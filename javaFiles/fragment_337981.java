MyEntityA entity = MyEntityADAO.findEntity(param1, param2)
 if (entity == null) {
      entity = .../create entity

      MyEntityADAO.save(entity);
      HibernateUtil.getCurrentSession().getTransaction().commit();
      HibernateUtil.getCurrentSession().getTransaction().begin();


 }