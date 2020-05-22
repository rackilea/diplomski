Criteria criteria = session.createCriteria(abc.class);
DetachedCriteria detachedCriteria = DetachedCriteria
         .forClass(xyz.class)  
         .setProjection(Property.forName("customerID"));
detachedCriteria.add(Restrictions.eq("customerName","rohit"));
criteria.add(Property
                    .forName("customerID")
                    .in(detachedCriteria));