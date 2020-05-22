Query query = session.createQuery("SELECT CONCAT(p.FIRSTNAME, ' ', p.LASTNAME) as Name,"
            + "a.mobile, a.email, p.patientId "
            + "FROM (SELECT l from login l where email= :email and password= :password) a "
            //---------------^-----------^
            + "INNER JOIN "
            + "patientprofile p ON a.loginId= p.loginId");
    query.setParameter("email", email);
    query.setParameter("password", password);