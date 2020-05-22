context.getRequest().getBody().flatMap({ data ->
    //parse data and get id
    //call to async service who returns Promise
    return service.getReport(id).map((String report) -> {
        // do some staff
    })
 }).then({
     //final staff before send response
     //import static ratpack.jackson.Jackson.json; 
     context.getResponse().send(json(result).toString());
 })