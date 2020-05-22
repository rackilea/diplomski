Specification<com.bitweb.syda.data.entity.service.Service> spec = (root, cq, cb) -> {
    if(!Long.class.isAssignableFrom(cq.getResultType())) {

        if(sort.contains("jobs")) {
            Join<Service, Job> jobs = root.join("jobs");
            //check for asc or desc
            cq.orderBy(cb.asc(jobs.get("updateTime")));
        }
        cq.distinct(true);
    }
    //else {
         //create a query for count case if needed 
    //}
    return null;
};