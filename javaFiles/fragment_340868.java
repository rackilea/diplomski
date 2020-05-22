public int StatDoctorBySpeciality() {
       int count =0;
    List<Long> results = em
            .createQuery("SELECT  COUNT(u)  FROM User AS u where u.role like 'doctor'  GROUP BY u.specialite").getResultList();
    for (Long result : results) {

         count = ((Number) result).intValue();
    }  
    return count ;
}