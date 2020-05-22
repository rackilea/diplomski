@Override
    public List<Bank> listBank() {
        List<Bank> list = getHibernateTemplate().find(
              " from Bank");
    return list;
    }