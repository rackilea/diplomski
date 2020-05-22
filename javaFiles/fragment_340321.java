Criteria c = createCriteria();
c.add(Restrictions.eq("seller", query.getSeller()));
c.add(Restrictions.eq("productAccountType", query.getProductAccountType()));
c.createCriteria("product").createCriteria("productStyle").createCriteria("productTemplate", "pt");
c.setProjection(Projections.distinct(Projections.property("pt.id")));
List<Object> objects = c.list();