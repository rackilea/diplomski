String selectQuery = 
            "from User as user " +
            "left join fetch user.categories as category " +
            "where " +
            "   user.email = :email";
User user = (User) session.createQuery(selectQuery).
        setString("email", email).
        uniqueResult();
return user;
//then filter the user.categories by the after criteria