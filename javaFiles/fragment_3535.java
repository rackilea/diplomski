@Override
    @Transactional
    public List<UserGroup> findUserGroupOf(UserAccount userAccount) {
        Criteria criteria = getSession().createCriteria(UserGroup.class);
        criteria.createAlias("userAccountsRole", "userAccountsRole");
        criteria.createAlias("userAccountsRole.userAccountList", "userAccountList");
        criteria.add(Restrictions.eq("userAccountList.id", userAccount.getId()));
        return criteria.list();

    }