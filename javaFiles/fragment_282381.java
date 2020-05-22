PreStatement = myConnection.prepareStatement(""
                        + "SELECT AVG(Game1.Score),Students.FirstName,Students.LastName "
                        + "FROM Game1 " 
                        + "INNER JOIN Students " 
                        + "ON Game1.StudentID = Students.StudentID " 
                        + "ORDER BY Students.FirstName ASC;");