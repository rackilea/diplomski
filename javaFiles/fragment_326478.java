Query query = em.createNamedQuery("SysRoles .findAll", SysRoles.class);
        //Pagination
        query.setFirstResult(lowItemIndex);
        query.setMaxResults(maxResults);
List<SysRoles> sysUsers= query.setParameter("isActive", "Y")
                 //ditection of sorting
                .setParameter("orderDirection", direction)
                 //name of sorting columns
                .setParameter("orderField", orderByColumnName).getResultList();