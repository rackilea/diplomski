List list = new ArrayList();
    if(!resultSet.isBeforeFirst()){
    resultSet.afterLast();
    resultSet.previous();
    User user = new User;
    list.add(user);
    }
    return list;