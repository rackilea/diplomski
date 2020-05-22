public class PersonSqlBuilder {

        public String selectPersonLike(PersonFilter filter) {
            return new SQL() {{
                SELECT("P.ID, P.USERNAME, P.PASSWORD, P.FIRST_NAME, P.LAST_NAME");
                FROM("PERSON P");
                if (filter.getId() != null) {
                    WHERE("P.ID like #{id}");
                }
                if (filter.getFirstName() != null) {
                    WHERE("P.FIRST_NAME like #{firstName}");
                }
                if (filter.getLastName() != null) {
                    WHERE("P.LAST_NAME like #{lastName}");
                }
                ORDER_BY("P.LAST_NAME");
            }}.toString();
        }
    }