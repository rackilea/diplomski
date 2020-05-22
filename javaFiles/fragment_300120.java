Collector<Employee, EmployeeInfo, EmployeeInfo> empToInfo = Collector.of(
     () -> new EmployeeInfo("", new ArrayList<String>()),
            (info, e) -> { 
                info.AddAccount(e.getAccount());
                info.setName(e.getName());
                },
     (p1,p2) -> p1.addToList(p2));

Collector<Employee, ?, Collection<EmployeeInfo>> byName = collectingAndThen(groupingBy(Employee::getName, empToInfo), 
                  (Map<String, EmployeeInfo> finisher) -> {return finisher.values();});

Map<Integer, Collection<EmployeeInfo>> r2 = employees.stream().collect(groupingBy(Employee::getDept, byName));