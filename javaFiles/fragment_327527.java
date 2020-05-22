try {
 synchronized(TestBolt.class) {
    if (null == employeeIdToNameMap) {
    employeeIdToNameMap = createEmployeIdToNameMap();
    }
  }  
} catch (SQLException e) {
 ...
}