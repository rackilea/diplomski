Resource res = null;
try{
res = //aquire resource
    //do stuff 
}catch(Exception e /*or whatever*/){
 //handle exceptions
}finally{
    if(null != res){
        res.close();
    }
}