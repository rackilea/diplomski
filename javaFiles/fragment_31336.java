public void update(ABCEntity transientInstance) {
        // TODO Auto-generated method stub
        try {
            getSession().saveOrUpdate(transientInstance);
            return transientInstance;
        } catch (RuntimeException re) {
            re.printStackTrace();
            return null;
        }
    }