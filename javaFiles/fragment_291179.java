String employeeId = 'D2309';
String name = "%brady%";

List<Integer> userRights = new ArrayList<Integer>();
userRights.add(1);
userRights.add(2);
userRights.add(3);

// build the input string
StringBuilder sb = new StringBuilder();
for (int i = 0; i < userRights.size; i++) {
    sb.append("?");
    if (i < userRights.size() - 1) {
        sb.append(", ");
    }
}

// build the SQL
String sql = "SELECT * FROM T_EMPLOYEE WHERE EMPLOYEE_ID = ?" +
    " AND NAME LIKE ?" +
    " AND RIGHT IN (" + sb.toString() + ")";

// init the object array
// size is employeeId + name + right
Object[] param = new Object[2 + userRights.size()];

// fill it
param[0] = employeeId;
param[1] = name;

for (int i = 0; i < userRights.size(); i++) {
    param[i + 2] = userRights.get(i);
}

jdbcTemplate.query(sql, param, new EmployeeRowMapper());