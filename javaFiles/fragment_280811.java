while(rs.next())
{
asset_id = rs.getString("asset_id");
name = rs.getString("name");
project = rs.getString("project");
emp_id = rs.getString("emp_id");
emp_name=rs.getString("emp_name");
model.addRow(new Object[]{asset_id, name, project, emp_id,emp_name});
//i++; 
}