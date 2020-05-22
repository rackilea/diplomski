public ArrayList<ProfilePic> FetchImage(ProfilePic profilePic) {
        String hql = "select data from  ProfilePic  where userId = :userId1 ";

        logger.info( profilePic.getUserId());

        Query query =  (Query) sessionFactory.getCurrentSession().createQuery(hql)
                .setParameter("userId1", profilePic.getUserId());


            return (ArrayList<ProfilePic>) query.List(); 
        }