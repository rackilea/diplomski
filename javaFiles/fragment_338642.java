DetachedCriteria dc = getDetachedCriteria();
dc.createAlias("userLoginStatus", "uls");
dc.add(Projections.property("firstName")); 
dc.add(Projections.property("lastName"));
dc.add(Projections.property("userType")); 
dc.addOrder(Order.asc("firstName")); 
return getAll(dc, pageSetting);