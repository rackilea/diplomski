List<Job> jobs = shipment.getJobs();
Job shoppingJob = null;
Job deliveryJob = null;
if (jobs != null) {
    for (Job job : jobs) {
        if (shoppingJob == null && job.isShopping()) { // this is the first shopping job
            shoppingJob = job;
            if (deliveryJob != null) { // we can break after finding a match for both conditions
                break;
            }
        }
        if (deliveryJob == null && (job.isDelivery() || job.isRanger())) { // this is the first delivery or range job
            deliveryJob = job;
            if (shoppingJob != null) { // we can break after finding a match for both conditions
                break;
            }
        }
    }
}