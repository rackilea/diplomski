aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE Persoon
  SET leeftijd=?,voornaam=?,achternaam=?,datum=?,locatieId=?,filmId=? 
    WHERE persoonId=?", new Object[] 
 { nieuwePersoon.getLeeftijd(),
 nieuwePersoon.getVoornaam(), 
 nieuwePersoon.getAchternaam(), 
 nieuwePersoon.getDatum(), 
 nieuwePersoon.getLocatieId(),
 nieuwePersoon.getFilmId()

 // persoonId missing!!
  });