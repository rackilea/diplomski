Criteria criteria=session.createCriteria(Student.class);
     criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
     criteria.add(Restrictions.ne("enquiryStatus", ENQUIRY.JOINED));
     criteria.setMaxResults(10);
     criteria.setFirstResult((paginate.getStartIndex()-1)*10);
     List<Student> students = criteria.list();

    criteria.setProjection(null);
    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    Long resultCount = (Long)criteria.uniqueResult();