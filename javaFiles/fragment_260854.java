Junction<Ticket> filters = Ebean.find(Ticket.class).where().disjunction();

    if(filter.getId() != null){
      filters.add(Expr.eq("id", filter.getId()));
    }
    return filters.endJunction().findList();