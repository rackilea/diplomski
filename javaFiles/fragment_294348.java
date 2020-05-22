@Transactional(readOnly=true)
public locate_requestJDBC findUserById(String GUID) {
    return jdbcTemplate.queryForObject(
        "select locate_request_guid,user_name,work_description,request_point.STAsText() request_point, request_polygon.STAsText() request_polygon from tablename where locate_request_guid=?",
        new Object[]{GUID}, new LocateRowMapper());
}