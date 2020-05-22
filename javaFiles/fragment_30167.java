public class RemoteDBAdapter {


    public String register(String email, String password) throws Exception
    {
        RestClient c = new RestClient("http://myurl/Account/Register");
        c.AddHeader("Accept", "application/json");
        c.AddHeader("Content-type", "application/json");
        c.AddParam("Email", email);
        c.AddParam("Password", password);

        c.Execute(RequestMethod.POST);

        JSONObject key = new JSONObject(c.getResponse());

        return key.getString("status");


    }

}