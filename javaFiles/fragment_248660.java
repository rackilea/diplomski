String query="INSERT INTO students  
    (FirstName,LastName,FatherName,Gender,DateOfBirth,Class,Address) VALUES "
    + "('" + studentdata.getFirstName() +" ', ' "+ studentdata.getLastName() +" ', '"+ 
    studentdata.getFatherName() +" ',  '" +  studentdata.getGender() +" ' , '"+ 
    studentdata.getDob() +" ' , '" + studentdata.getClassNo() 
    + " ' , '" + studentdata.getAddress() + " ' )" ;