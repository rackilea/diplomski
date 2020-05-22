while (rs.next()) {
    DepartmentBean department = new DepartmentBean();
    department.setDepartment_name(rs.getString("department_name"));
    department.setDepartment_id(rs.getInt("department_id"));
    departments.add(department);
}