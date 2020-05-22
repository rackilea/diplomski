Specification<com.bitweb.syda.data.entity.service.Service> spec = (root, cq, cb) -> {
    if(!Long.class.isAssignableFrom(cq.getResultType())) {
        cq.distinct(true);
    }
    //else {
         //create a query for count case if needed 
    //}
    return null;
};