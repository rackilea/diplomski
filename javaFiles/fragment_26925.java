/**
     * Returns a list with the public IPs of all the active instances, which are
     * returned by the {@link #getActiveInstances()} method.
     * 
     * @return  a list with the public IPs of all the active instances.
     * @see     #getActiveInstances()
     * */
    public List<String> getPublicIPs(){
        List<String> publicIpsList = new LinkedList<String>();

        //if there are no active instances, we return immediately to avoid extra 
        //computations.
        if(!areAnyActive())
            return publicIpsList;

        DescribeInstancesRequest request =  new DescribeInstancesRequest();
        request.setInstanceIds(instanceIds);

        DescribeInstancesResult result = ec2.describeInstances(request);
        List<Reservation> reservations = result.getReservations();

        List<Instance> instances;
        for(Reservation res : reservations){
            instances = res.getInstances();
            for(Instance ins : instances){
                LOG.info("PublicIP from " + ins.getImageId() + " is " + ins.getPublicIpAddress());
                publicIpsList.add(ins.getPublicIpAddress());
            }
        }

        return publicIpsList;
    }