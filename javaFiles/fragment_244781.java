Query q = em.createQuery("SELECT a FROM Applicants a WHERE a.lastMod <= :dateParam ORDER BY a.applDate ASC");
q.setParameter("dateParam", dateParam);
List<Applicants> applicants = (List<Applicants>)q.getResultList();

// or, to avoid casting (thanks to @DavidSN)

TypedQuery<Applicants> q = em.createQuery("SELECT a FROM Applicants a WHERE a.lastMod <= :dateParam ORDER BY a.applDate ASC", Applicants.class);
q.setParameter("dateParam", dateParam);
List<Applicants> applicants = q.getResultList();