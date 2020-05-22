List<Object[]> tuples = (List<Object[]>) session.createQuery(query).list();

for(Object[] tuple : tuples) {
    UserEntity ue = tuple[0];
    Number roleId = tuple[1];
}