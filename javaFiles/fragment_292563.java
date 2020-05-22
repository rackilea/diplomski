public List<Foo> getByName(List<Integer> codes, String namePart) {
    String sql = "select * from FOO where CODE in (:codes) and NAME like :name"
    Map<String,Object> params = new HashMap<String,Object>();
    params.put("codes", codes);
    params.put("name", namePart+"%");
    return getSimpleJdbcTemplate().query(sql, new FooRowMapper(), params);
}