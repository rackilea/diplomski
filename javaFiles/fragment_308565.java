static void payOneEmployee(Scanner aScanner)
    {
        Employee anEmployee = new Employee();

        List<String> employeeValueList = new ArrayList();
        while (aScanner.hasNext())
        {
            employeeValueList.add(aScanner.next());
        }

        if (!employeeValueList.isEmpty())
        {
            anEmployee.setName(employeeValueList.get(0));
            anEmployee.SetJobTitle(employeeValueList.get(1));
            anEmployee.cutCheck(new Double(employeeValueList.get(2)));
        }

    }