private void waitForInstanceState(List<String> instancesId, InstanceStateName state) {
        int numAchievedState = 0;

        while (numAchievedState != instancesId.size()) {

            try {
                Thread.sleep(15000);
            } catch (InterruptedException ex) {
                Logger.getLogger(AmazonLibrary.class.getName()).log(Level.SEVERE, null, ex);
            }

            numAchievedState = 0;

            DescribeInstancesRequest describeInstance = new DescribeInstancesRequest().withInstanceIds(instancesId);
            DescribeInstancesResult describeResult = ec2.describeInstances(describeInstance);
            List<Reservation> reservations = describeResult.getReservations();

            //different instances might be in different reservation requests
            //so we need to traverse those
            for (Reservation reservation : reservations) {
                List<Instance> instances = reservation.getInstances();
                for (Instance instance : instances) {
                    if (instance.getState().getName().equals(state.toString())) {
                        numAchievedState++;
                    }
                }
            }
        }
    }