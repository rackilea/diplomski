@Transactional
public AcmeUserBean loadUserByDn(String userDn) {
    AcmeUserBean result = null;
    Session session = this.getSessionFactory().getCurrentSession();

        Query query = session.createQuery(
            "from AcmeUserBean as user where user.distinguishedName = :userDn");
        query.setString("userDn", userDn);
        List objs = query.list();

        if (objs != null && objs.size() > 0) {
            result = (AcmeUserBean) objs.get(0);
        }

        return result;
}