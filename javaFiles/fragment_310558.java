@SuppressWarnings({ "unchecked", "rawtypes" })
  public List<Result> getPostList() throws Exception {
      session = sessionFactory.openSession();
      tx = session.beginTransaction();

      Criteria cr = session.createCriteria(Post.class);
      ProjectionList projList = Projections.projectionList();
      projList.add(Projections.sum("val"), "topValue");
      projList.add(Projections.groupProperty("userId"), "uid");
      cr.setProjection(projList);
      cr.setResultTransformer(Transformers.aliasToBean(Result.class));
      List<Result> postList = cr.list();
      // please make sure that you are using the class field name rather than database field name in below query.
      String updateHql = "update Result set topValue = :topValue where uid = :uid";
      Query query = null;
      for(Result result : postList){
        query=session.createQuery(updateHql);
        query.setLong("topValue", result.getTopValue());
        query.setLong("uid", result.getUid());
        query.executeUpdate();
        session.flush();
      }

      session.flush();
      tx.commit();
      return postList;
  }