String hql = "select Country c where c.name = :theName";
Query q = session.createQuery(hql);
q.setString("theName", theCountryIWantToSave.getName());
Country c = query.uniqueResult();
if (c != null) {
    // a country with the same name as theCountryIWantToSave already exists
}