HostConfiguration hostCfg = new HostConfiguration();
HttpClient client = new HttpClient();
HttpMethod method = new GetMethod("... your get query string");

int timeout = 5000; //config your value
method.getParams().setSoTimeout(timeout);

//the call
client.executeMethod(hostCfg, method);