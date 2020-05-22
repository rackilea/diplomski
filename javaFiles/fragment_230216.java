class AMapper implements RowMapper<A> {
    Map<Integer, A> aMap = new HashMap<>();

    public A mapRow(ResultSet rs, int num){
        A a = aMap.get(rs.getInt("id"));
        if(a == null){
           a = new A();
           a.setId(rs.getInt("a_id"));
           a.setName(rs.getString("a_name"));
           aMap.put(a.getId(), a);
        }
        B b = new B();
        b.setId(rs.getInt("b_id");
        b.setName(rs.getString("b_name"));
        a.addB(b);
    }
}