Criteria criteria = getSession().createCriteria(A.class);
criteria.createCriteria("objectB")
        .createCriteria("objectC").add(Restrictions.idEq(networkID));

//Syntax error occurs here, missing add
criteria.createCriteria("objectB")
        .(Restrictions.like("comment", "%" + comment + "%"));

//Fix
criteria.createCriteria("objectB").add(Restrictions.like("comment", "%" + comment + "%"));