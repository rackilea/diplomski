public ABCEntity findById(Integer id) {
        // TODO Auto-generated method stub
        try {
            ABCEntity instance = (ABCEntity) getSession()
                    .createCriteria(ABCEntity.class)
                    .add(Restrictions.eq(IDABCENTITY, id)).uniqueResult();
            return instance;
        } catch (RuntimeException re) {
            throw re;
        }
    }