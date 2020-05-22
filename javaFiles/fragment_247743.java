Gson gson = new Gson();

List<BodyHolder> bodies = gson.fromJson(response1, 
   new TypeToken<List<BodyHolder>>() {}.getType());

List<BatchAccounts> result = new ArrayList<BatchAccounts>(bodies.size());
for (BodyHolder holder: bodies) {
    BatchAccounts a = new BatchAccounts();
    a.setBody(gson.fromJson(holder.getBody(), Account.class);
    result.add(a);
}

public class BodyHolder
{
    private String body;
    ...    
}