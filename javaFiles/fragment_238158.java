private static void getEmployeeById()
{
final String uri = 
"http://localhost:8080/springrestexample/employees/{id}";

Map<String, String> params = new HashMap<String, String>();
params.put("id", "1");

RestTemplate restTemplate = new RestTemplate();
EmployeeVO result = restTemplate.getForObject(uri, EmployeeVO.class, 
params);

System.out.println(result);
}