Criteria factureCrit = session.createCriteria(Facture.class);
Criteria panierCrit = factureCrit.createCriteria("panier");
Criteria clientCrit = panierCrit.createCriteria("client");
clientCrit.add(Restrictions.idEq(clientId));

return factureCrit.list();