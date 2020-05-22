try{
//}catch (FirstException e) -- I removed this, as you are only catching it and then directly
                        //     throwing it, which seems uneecessary
}catch (RetryException r){
    //process r
    throw r;
}