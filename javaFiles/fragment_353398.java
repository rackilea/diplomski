private static List<String[]> toStringArray(List<Employee> emps) {
        List<String[]> records = new ArrayList<String[]>();
        //add header record
        records.add(new String[]{"ID","Name","Role","Salary"});
        Iterator<Employee> it = emps.iterator();
        while(it.hasNext()){
            Employee emp = it.next();
            records.add(new String[]{emp.getId(),emp.getName(),emp.getRole(),emp.getSalary()});
        }
        return records;
    }