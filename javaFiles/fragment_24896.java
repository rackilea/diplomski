// the following code assumes: import org.apache.commons.lang.*;
String tableName="employee";
List<String> columnsList = new ArrayList<String>();
columnsList.add("emp_id");  //
columnsList.add("name");    // sample data
columnsList.add("salary");  //
String colString = StringUtils.join(columnsList, ',');
String paramString = StringUtils.repeat(",?", columnsList.size());
String sql = String.format(
        "INSERT INTO %s (%s) VALUES (%s)", 
        tableName, colString, paramString.substring(1));
System.out.println(sql);