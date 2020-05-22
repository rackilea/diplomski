String sql = "SELECT * FROM Employee WHERE EMP_ID = ?";
            Employee emp = (Employee)getJdbcTemplate().queryForObject(
                    sql, new Object[] { empId }, new RowMapper() {

                        @Override
                        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                            Employee emp = new Employee();
                            emp.setEmpId(rs.getInt("EMP_ID"));
                        }
                    });