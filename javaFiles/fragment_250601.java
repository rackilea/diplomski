static class UpdateJobRouteAssignment implements StateUpdater,JobInsertedListener,InsertionStartsListener {

        StateManager stateManager;

        UpdateJobRouteAssignment(StateManager stateManager) {
            this.stateManager = stateManager;
        }

        @Override
        public void informJobInserted(Job job2insert, VehicleRoute inRoute, double additionalCosts, double additionalTime) {
            stateManager.putProblemState(stateManager.createStateId(job2insert.getId()), VehicleRoute.class, inRoute);
        }

        @Override
        public void informInsertionStarts(Collection<VehicleRoute> vehicleRoutes, Collection<Job> unassignedJobs) {
            for(VehicleRoute r : vehicleRoutes){
                for(Job j : r.getTourActivities().getJobs()){
                    informJobInserted(j,r,0.,0.);
                }
            }
        }
    }