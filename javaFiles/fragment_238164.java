private static void deleteEmployee()
{
final String uri = 
"http://localhost:8080/springrestexample/employees/{id}";

Map<String, String> params = new HashMap<String, String>();
params.put("id", "2");

RestTemplate restTemplate = new RestTemplate();
restTemplate.delete ( uri,  params );
}