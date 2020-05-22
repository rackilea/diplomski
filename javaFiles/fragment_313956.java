@NamedQuery(name="updatedetails",query="update myentity set enddesc = :enddesc, startdesc = :startdesc Where id = :id")

List<myentity> results = em.createNamedQuery("updatedetails", myentity.class)
                           .setParameter("enddesc", "abcd")
                           .setParameter("startdesc", "gjvg")
                           .setParameter("id", "gghjj")
                           .getResultList();