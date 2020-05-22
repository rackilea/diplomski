public LoginInfoAdmin getEmpById(String username){  
    try {
        String sql="select * from ADMINLOGINDETAILS where username=?";  

        return template.queryForObject(sql, new Object[]{username},new BeanPropertyRowMapper<LoginInfoAdmin>(LoginInfoAdmin.class));  
    } catch (EmptyResultDataAccessException erdae) {
        return null;
    }
}