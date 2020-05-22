public String readJSONFeed(String ... params){

    if (params.lenght % 2 != 0) return null;

    List<NameValuePair> params = new ArrayList<NameValuePair>(params.lenght / 2);
    for (int i = 0; i < params.lenght - 1; i += 2) {
        params.add(new BasicNameValuePair(params[i], params[i + 1]));
}

//calling
readJSONFeed(name1, value1, name2, value2, name3, value3); etc