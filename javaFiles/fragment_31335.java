public ABCEntity findById(Integer id) {
            // TODO Auto-generated method stub

         try {
                ABCEntity instance = (ABCEntity) getSession().get(
                        "packageofclass.ABCEntity", id);
                return instance;
            } catch (RuntimeException re) {
                log.error("get failed", re);
                throw re;
            }
        }