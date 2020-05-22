string updateSql = "UPDATE Employees " + "SET LastName = @LastName " + "WHERE FirstName = @FirstName";             
SqlCommand UpdateCmd = new SqlCommand(updateSql, thisConnection);              
UpdateCmd.Parameters.Add("@FirstName", SqlDbType.NVarChar, 10, "FirstName");                   
UpdateCmd.Parameters.Add("@LastName", SqlDbType.NVarChar, 20, "LastName");
UpdateCmd.Parameters["@FirstName"].Value = "Wade";            
UpdateCmd.Parameters["@LastName"].Value = "Harvey";            
UpdateCmd.ExecuteNonQuery();