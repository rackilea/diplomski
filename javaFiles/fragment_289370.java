//create load balancer
        CreateLoadBalancerRequest lbRequest = new CreateLoadBalancerRequest();
        lbRequest.setLoadBalancerName("loader");
        List<Listener> listeners = new ArrayList<Listener>(1);
        listeners.add(new Listener("HTTP", 80, 80));
        lbRequest.withAvailabilityZones(availabilityZone1,availabilityZone2);
        lbRequest.setListeners(listeners);

        CreateLoadBalancerResult lbResult=elb.createLoadBalancer(lbRequest);
        System.out.println("created load balancer loader");