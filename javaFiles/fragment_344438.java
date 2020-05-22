Criteria criteria = hibernetSession.createCriteria(WishList.class);
criteria.createAlias("item", "itemAlias")
.setProjection(Projections.projectionList()
.add(Projections.property("id"),"id")
.add(Projections.property("itemAlias.id"),"itemAlias.id")
.add(Projections.property("itemAlias.productCategory"),"itemAlias.productCategory")
.add(Projections.property("itemAlias.productName"),"itemAlias.productName")
.add(Projections.groupProperty("itemAlias.productName")))
.setResultTransformer(Transformers.aliasToBean(WishList.class));
List<WishList> itemList = criteria.list();