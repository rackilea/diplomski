IClient client = new ClientBuilder("https://api.starter-us-east-1.openshift.com")
                .withUserName("aaa@bbb.com")
                .withPassword("password")
                .build();

        client.getAuthorizationContext().setToken("oqW-8xm8in6QcEaQXtM2ZEQ");

        System.out.println("=======================================================================");
        System.out.println(client.getOpenShiftAPIVersion() + ", " + client.getServerReadyStatus());


        System.out.println("\n========================Openshift Project====================================");
        IProject project = (IProject)client.getResourceFactory().stub(ResourceKind.PROJECT, "josephproject-openshift");
        System.out.println("Openshift API version : " + project.getApiVersion() 
                +", Project namespace : " + project.getNamespace() + ", Project name : " + project.getName());  


        System.out.println("\n========================Openshift Pods==============================");
        List<IPod> pods = client.list(ResourceKind.POD, "josephproject-openshift");
        //IPod pod = (IPod) pods.stream().filter(p->p.getName().startsWith("docker-registry")).findFirst().orElse(null);
        for(IPod pod : pods) {
            System.out.println(pod.getName());
            System.out.println("Pod Host : " + pod.getHost() + ", Pod Namespace : " + pod.getNamespace() 
                    + " ,Pod Creation Time :" + pod.getCreationTimeStamp());
            System.out.println("Pod Status : " + pod.getStatus() + "\n" + pod.toJson());
        }