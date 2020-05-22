session.createQuery(hqlQuery)
        .setString("searchText", searchText)
        .iterate();
// or
session.createQuery(hqlQuery)
        .setString(0, searchText)
        .iterate();