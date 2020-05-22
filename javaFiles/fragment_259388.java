while(!Context.current().isCancelled()){ // THIS LINE CHANGED
    if(changeFeedResponse!=null && !changeFeedResponse.getFinalize()){
        responseObserver.onNext(changeFeedResponse);
       changeFeedResponse = processData(responseObserver, changeFeedResponse.getToDate(), changeFeedResponse.getPageNo());
    }else{
        break;
    }
}