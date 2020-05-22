HashMap<String, Map<String, String>> userAnswers = new HashMap<>();
BufferedReader reader = new BufferedReader(new FileReader("/PATH/TO/YOUR/FILE.cvs"));
String ln;
while((ln = reader.readLine()) != null)
{
    String [] split = ln.split(",");
    String user = split[0];
    Map<String, String> userMap = userAnswers.get(user);
    if(userMap == null)
    {
        userMap = new HashMap<String, String>();
        userAnswers.put(user, userMap);
    }

    userMap.put(split[1], split[2]);
}

reader.close();