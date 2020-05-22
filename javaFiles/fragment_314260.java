@RequestMapping(value="/updateJob", method=RequestMethod.GET)
public @ResponseBody String updateJob(@RequestParam(value="job_id") String job_id){
    Integer jobid = Integer.parseInt(job_id);

    JobQueue job = jobqueueService.getJob(jobid);
    .
    .
    return null;
}