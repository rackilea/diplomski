java.time.LocalDate today = java.time.LocalDate.now();
List<FoundObject> lst = em.createQuery(hqlstring, FoundObject.class)
        .setParameter("cd", today.minusDays(1))
        .setParameter("uom", "EACH") // or variable, instead of constant
        .setParameter("inum", "I1") // or variable, instead of constant
        .setParameter("sd", today.plusDays(5))
        .setParameter("fc", "IN") // or variable, instead of constant
        .setParameter("tc", "IN") // or variable, instead of constant
        .getResultList();