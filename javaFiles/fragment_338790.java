public boolean readJob(Application application) {
    // do some validation stuff and read properties from Job
    String myproperty = this.job.getProperty("jobtype");

    // Here I need your advise
    // How to call a method from the parent class??
    application.setjobtype(myproperty); // <= parent is just for Demonstration!
}