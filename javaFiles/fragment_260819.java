public class Controller {
    . . .
    public ResponseEntity<JobResponse> getJob(boolean withDocuments, long jobId) {
        JobResponse response;
        Job job = jobService.getJob(jobId); // assuming you are getting job somehow
        if (withDocuments) {
            response = JobResponse.fromJobWithDocuments(job)
        } else {
            response = JobResponse.fromJob(job)
        }
        return new ResponseEntity<JobResponse>(response);
    }
    . . .
}