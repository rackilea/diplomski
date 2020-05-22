Employee[] method(String[] employeeNames,
                  Integer[] employeeAges,
                  float[] employeeSalaries)
{
    if (employeeNames == null
        || employeeAges == null 
        || employeeSalaries == null)
    {
        throw new NullPointerException();
    }
    int size = employeeNames.length;
    if (employeesAges.length != size || employeeSalaries.length != size)
    {
        throw new IllegalArgumentException
            ("Names/ages/salaries must be the same size");
    }
    ...
}