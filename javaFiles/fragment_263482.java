ClientConfig cc = new DefaultClientConfig();
cc.getClasses().add(JSONArrayProvider.App.class);
Client c = Client.create(cc);

JSONArray array = new JSONArray();
array.put(1);
array.put(4);

c.addFilter(new LoggingFilter());
c.resource("http://a.cz").type(MediaType.APPLICATION_JSON_TYPE).post(array);