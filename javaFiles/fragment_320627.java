public List<Result> getResultList() throws Exception {
    session = sessionFactory.openSession();
        Criteria cr = session.createCriteria(Post.class);
        ProjectionList projList = Projections.projectionList();
        projList.add(Projections.sum("val"), "topValue");
        projList.add(Projections.groupProperty("userId"), "uid");
        cr.setProjection(projList);
        cr.setResultTransformers(Transformers.aliasToBean(Result.class)
        List postList = cr.list();
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return postList;
    }
    }