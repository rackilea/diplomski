sessionFactory.getCurrentSession().beginTransaction();
            Criteria criteria = sessionFactory.getCurrentSession().createCriteria(LoginHistory.class);
            criteria.add(Restrictions.eq("id",id));
            LoginHistory loginHistory = (LoginHistory)criteria.uniqueResult();
            loginHistory.setLogoutTime(AdminUtil.getTimeStamp());
            sessionFactory.getCurrentSession().update(loginHistory);