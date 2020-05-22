ComparatorChain chain = new ComparatorChain();
             chain.addComparator(Employee.COMPARE_BY_COMPANY);
             chain.addComparator(Employee.COMPARE_BY_GOVERNMENT);
             chain.addComparator(Employee.COMPARE_BY_UNIVERSITY);


             Collections.sort(EmployeeList, chain);