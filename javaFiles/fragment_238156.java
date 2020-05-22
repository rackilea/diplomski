private static void getEmployees()
{
final String uri = "http://localhost:8080/springrestexample/employees";
RestTemplate restTemplate = new RestTemplate();

EmployeeListVO result = restTemplate.getForObject(uri, 
EmployeeListVO.class);

System.out.println(result);