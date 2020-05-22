class SalaryComparator implements Comparator {
        public int compare(Object paramObject1, Object paramObject2) {
            Emp localEmp1 = (Emp) paramObject1;
            Emp localEmp2 = (Emp) paramObject2;
            int result = localEmp1.getName().compareTo(localEmp2.getName());
            if (result == 0) {
                result = localEmp1.salary - localEmp2.salary;
            }
            return result;
        }
    }