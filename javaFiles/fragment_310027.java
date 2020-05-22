Criteria cr = getCurrentSession().createCritiera(Extension.class) 
.setProjection(Projections.projectionList()
.add(Projections.distinct(Projections.property("extcat")))
.add(Projections.property("extid"), "extid")
.add(Projections.property("extName"), "extName"))
.setResultTransformer(Transformers.aliasToBean(Extension.class));
List<Extension> list = cr.list();