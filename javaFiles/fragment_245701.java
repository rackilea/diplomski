Iterator<Job> iter = goodJobs.iterator();
while (iter.hasNext()) {
    Job j = iter.next();
    if (j.getArrivalTime() > time) {
        jobList.insert(j);
        iter.remove();
    }
}