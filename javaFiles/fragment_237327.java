try {
      // statement to insert like
      // insert into Activity (ActivityName, EmployeeeName, DepartmentName, roleId)
      //     values (?, ?, ?, ?)
    } catch ... {
      // If the exception is caused by primary key violation,
      // then such ActivityName already existed and we can ignore this exception
    }