try {
     EntityTransaction trx = em.getTransaction();
     trx.begin();   
      for (LetterEntity l : lettersToDel) {
              em.createQuery("delete  from LetterEntity l where l = :letter")
                 .setParameter("letter", l)
                 .executeUpdate();
     trx.commit();
      }
    } catch (Exception e) {
        e.printStackTrace();
    }