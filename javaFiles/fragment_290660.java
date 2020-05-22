@SuppressWarnings("unchecked")
List<Event> events = (List<Event>) session.createQuery(
    "FROM Event e WHERE e.enabled = TRUE e.date > :now"
)
.setDate("now", currDate.getTime())
.list();