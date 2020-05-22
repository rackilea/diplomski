Query q1=em.createQuery("SELECT TaUser AS tu WHERE tu.userId = :USERID");
//em is entityManager object
q1.setInteger("USERID",34);
//here 34 is the dynamic value or if there is any relationship with
// another entity then set the object reference of the other entity.
q1.getResultList(); //return list of data.