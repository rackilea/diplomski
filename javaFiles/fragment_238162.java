private static void deleteEmployee()
{
final String uri = 
"http://localhost:8080/springrestexample/employees/{id}";

Map<String, String> params = new HashMap<String, String>();
params.put("id", "2");

EmployeeVO updatedEmployee = new EmployeeVO(2, "New Name", "Gilly", 
"test@email.com");

RestTemplate restTemplate = new RestTemplate();
restTemplate.put ( uri, updatedEmployee, params);
}