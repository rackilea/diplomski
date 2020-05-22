String selectQuery = 
            "select user, category " +
            "from User as user " +
            "left join user.categories as category with category.updated >= :after " +
            "where " +
            "   user.email = :email";
List userAndCategories = session.createQuery(selectQuery).
        setString("email", email).
        setCalendar("after", after).
        list();     
//userAndCategories contains Object[] entries where the User is the Object[0] is the user and Object[1] is the Category