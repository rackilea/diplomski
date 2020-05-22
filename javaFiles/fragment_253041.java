HttpClient client = new HttpClient();

object anonymousObject = new
{
    firstName = "sunny",
    lastName = "leone",
    timeStamp = "test"
};

string jsonContent = JsonConvert.SerializeObject(anonymousObject);

var request = new HttpRequestMessage(HttpMethod.Post, "http://127.0.0.1:8080/user");
request.Content = new StringContent(jsonContent, Encoding.UTF8, "application/json");

HttpResponseMessage response = await client.SendAsync(request);

Console.WriteLine(await response.Content.ReadAsStringAsync());