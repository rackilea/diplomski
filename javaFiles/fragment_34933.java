@Query("select new example.UserPlainDto( " + 
       "  a.user.id, " +
       "  count(distinct c.id), " +
       "  a.type, " +
       "  count(distinct a.id) " +
       ") " +
       "from " +
       "  Action a " +
       "  join Contact c on c.user.id = a.user.id " +
       "group by " +
       "  a.user.id, a.type")
List<UserPlainDto> getUserPlainDtos();