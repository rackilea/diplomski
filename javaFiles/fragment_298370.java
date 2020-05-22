while (resultSet.next()) {
    writer.append("<employee>");
    writer.append("<emp_id>").append(resultSet.getString("emp_id")).append("</emp_id>");
    writer.append("<emp_name>").append(resultSet.getString("emp_name")).append("</emp_name>");
    writer.append("<emp_addr>").append(resultSet.getString("emp_addr")).append("</emp_addr>");
    writer.append("</employee>");
}