AWSElasticBeanstalk client = new AWSElasticBeanstalkClient(); 
    client.setEndpoint(<set your endpoint>);
    RestartAppServerRequest request = new RestartAppServerRequest()
            .withEnvironmentId(<set your env id>)
            .withEnvironmentName(<set your env name>);
    RestartAppServerResult response = client.restartAppServer(request);