private void getLatestStackSolutionVersion() {
    ListAvailableSolutionStacksResult response = beanstalkClient.listAvailableSolutionStacks();
    for (int i = 0; i < response.getSolutionStacks().size(); i++) {
        if (response.getSolutionStacks().get(i).contains("Java 8") {
            stackName = response.getSolutionStacks().get(i);
            break;
        }
    }    
}