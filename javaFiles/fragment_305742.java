long count = emps.values()
                 .stream()
                 .filter(employee -> employee.getName() != null)
                 .count();

/**
 * count == 0 => All employess dont have name
 * count == size => All employees have name
 */
return count == 0 || count == employees.size();