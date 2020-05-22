public class UserQueryBuilder {

    private Connection conn;
    private StringBuilder query = new StringBuilder("SELECT * FROM users");
    private List<ValueSetter> valueSetters = new ArrayList<ValueSetter>();

    // callback interface for setting the column values
    private interface ValueSetter {
        void setValue(PreparedStatement ps);
    }

    // the caller is responsible for closing the connection afterwards
    public QueryBuilder(Connection conn) {
        this.conn = conn;
    }           

    public QueryBuilder byId(final Integer id) {
        appendSeparator();
        query.append("id = ?");
        valueSetters.add(new ValueSetter() {
            public void setValue(PreparedStatement ps) {
                ps.setInt(id);
            }
        });
        return this;
    }   

    public QueryBuilder byEmail(String email) {
        appendSeparator();
        query.append("email = ?");
        valueSetters.add(new ValueSetter() {
            public void setValue(PreparedStatement ps) {
                ps.setString(email);
            }
        });
        return this;
    }   

    public QueryBuilder byUsername(String username) {
        appendSeparator();
        query.append("username= ?");
        valueSetters.add(new ValueSetter() {
            public void setValue(PreparedStatement ps) {
                ps.setString(username);
            }
        });
        return this;
    }

    private void appendSeparator() {
        if (filterValues.size() == 0) {
            query.append(" WHERE ")
        }
        else {
            query.append(" AND ")
        }
    }

    public PreparedStatment build() {
        PreparedStatement ps = conn.prepareStatement(query.toString());
        for(ValueSetter valueSetter : valueSetters) {
            valueSetter.setValue(ps);
        }
        return ps;
    }
}