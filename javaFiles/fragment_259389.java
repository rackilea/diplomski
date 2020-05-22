// THE NEXT TWO LINES CHANGED
ServerCallStreamObserver scso = (ServerCallStreamObserver) responseObserver;
while(!scso.isCancelled()){
    if(changeFeedResponse!=null && !changeFeedResponse.getFinalize()){
        responseObserver.onNext(changeFeedResponse);
       changeFeedResponse = processData(responseObserver, changeFeedResponse.getToDate(), changeFeedResponse.getPageNo());
    }else{
        break;
    }
}