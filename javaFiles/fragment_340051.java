st.executeUpdate("INSERT INTO ...", Statement.RETURN_GENERATED_KEYS);
int id;
try (ResultSet rs = st.getGeneratedKeys()) {
    rs.next();
    id = rs.getInt(1);
}

// ...