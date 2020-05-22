public List<FakeEmployeeDTO> getAllEmployeeList() throws IOException {

HttpClient client = HttpClientBuilder.create().build();
HttpGet getRequest = new HttpGet(url);
HttpResponse response = client.execute(getRequest);

Integer statusCode = response.getStatusLine().getStatusCode();
if (statusCode != 200) {
    throw new SystemException(ERROR_MESSAGE + statusCode);
}
BufferedReader rd = new BufferedReader( new InputStreamReader(response.getEntity().getContent(),
    "UTF-8"));  // if it is not working please try with ("ISO-8859-1")
String line = "";
StringBuilder jsonData = new StringBuilder();
while ((line = rd.readLine()) != null) {
    jsonData.append(line);
}
response.getEntity().getContent().close();
rd.close();
logger.info(jsonData.toString());

Gson gson = new GsonBuilder().setDateFormat("dd-MMM-yyyy").create();
Type listType = new TypeToken<List<FakeEmployeeDTO>>() {
}.getType();
List<FakeEmployeeDTO> employeeList = gson.fromJson(jsonData.toString(), listType);
sortEmployeeListByFirstName(employeeList);
return employeeList;}