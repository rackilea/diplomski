String hql = "select r from Recipe r " +
                "join r.tags t " +
                "where t.id in (:tags) " +
                "group by r " +
                "having count(t)=:tag_count";
Query query = session.createQuery(hql);
query.setParameterList("tags", tagIds);
query.setInteger("tag_count", tagIds.size());
List<Recipe> recipes = query.list();