Query query = session.createSQLQuery(
    "select group_concat(eg.name) " +
    "from event_groups eg " +
    "left join theatres t ON t.theatre_id = eg.theatre_id " +
    "group by t.theatre_id order by t.application_name");
List<Object[]> lstResult = query.list();