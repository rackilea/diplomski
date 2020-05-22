// The object under test
EmployeeExaminer ee = new EmployeeExaminer();

// A mock Employee used for tests:
Employee emp = mock(Employee.class);
when(emp.getName(1)).thenReturn("Jim");
when(emp.getName(2)).thenReturn("Mark");

// Assert EmployeeExaminer's behavior:
assertTrue(ee.isJim(emp, 1));
assertFalse(ee.isJim(emp, 2));