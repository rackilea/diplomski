List<StudentFeedback> results = null;

Session session = getSession();
Criteria criteria = session.createCriteria(StudentFeedback.class);

ProjectionList projlist = Projections.projectionList();
projlist.add(Projections.sum("totalFeedback").as("qty"));
projlist.add(Projections.groupProperty("feedbackStatus").as("feedName"));


criteria.setProjection(projlist);
criteria.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
results = criteria.list();

return GsonUtils.toGson(results);