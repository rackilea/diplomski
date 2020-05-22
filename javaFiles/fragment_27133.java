Admin.find.fetch("user", new FetchConfig().query())
    .where()
    .ilike("user.name", "%" + filter + "%")        
    .orderBy("user."+sortBy + " " + order)
    .findPagingList(pageSize)
    .getPage(page);