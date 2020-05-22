public class SiteAddressDaoImpl<T, Id extends Serializable> extends
        GenericDaoHibernateImpl implements SiteAddressDao {

    public List<SiteAddressModel> getSitesByBatch(String batchNumber) {
        List<SiteAddressModel> siteList;
        MigrationPlanDao migrationPlanDao = ServiceFactory.getO2SiteService()
                .getMigrationPlanDao();
        // working
        String hql = "from " + persistentClass.getName() + " where "
                + "siteType ='LLU/ASN' and  siteName in "
                + "(select distinct exchange from "
                + migrationPlanDao.getPersistentClass().getName()
                + " where migrationBatchNumber =" + "'" + batchNumber + "'"
                + ")";

        siteList = findbyHQL(hql);

        /*
         * // notWorking Query query = this.getSession().createQuery("from " +
         * persistentClass.getName() + " where " + "siteType =:" +
         * "type and  siteName in " + "(select distinct exchange from " +
         * migrationPlanDao.getPersistentClass().getName() +
         * " where migrationBatchNumber =:" + "batchNumber" + ")" );
         * 
         * query.setString("batchNumber", batchNumber); query.setString("type",
         * "LLU/ASN"); siteList = query.list();
         */

        /*
         * //working DetachedCriteria criteria =
         * DetachedCriteria.forClass(persistentClass);
         * criteria.add(Property.forName("siteName").eq("Barnet")); siteList =
         * getHibernateTemplate().findByCriteria(criteria);
         */

        /*
         * //notWorking Query query = this.getSession().createQuery("from " +
         * persistentClass.getName() + " where " + "siteName='Barnet'");
         * siteList = findbyHQLQuery(query);
         */

        /*
         * //working String hql = "from " + getPersistentClass().getName() +
         * " where " + "siteName='Barnet'" ; siteList = findbyHQL(hql);
         */

        return siteList;
    }
}

public class GenericDaoHibernateImpl<T, Id extends Serializable> extends
        HibernateDaoSupport implements GenericDao<T, Id> {
    public List<T> findbyHQL(final String hql) throws DaoException {
        getHibernateTemplate().setAlwaysUseNewSession(true);
        return getHibernateTemplate().executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session)
                    throws HibernateException, SQLException {
                // String str = "from " + persistentClass.getName() + " o";
                Query query = session.createQuery(hql);
                List<T> list = query.list();
                logger.debug("Find " + list.size() + " records.");
                return list;
            }
        });
    }

    public List<T> findbyHQLQuery(final Query hqlQuery) throws DaoException {
        getHibernateTemplate().setAlwaysUseNewSession(true);
        return getHibernateTemplate().executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session)
                    throws HibernateException, SQLException {
                List<T> list = hqlQuery.list();
                logger.debug("Find " + list.size() + " records.");
                return list;
            }
        });
    }
}