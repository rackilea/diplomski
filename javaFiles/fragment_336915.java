ApiAccess apiObj = new ApiAccess (0, "/User");
//Assign the AsyncTask's delegate to your class's context (this links your asynctask and this class together)
apiObj.delegate = this;
apiObj.execute(nameValuePairs); //ERROR

//this method has to be implement so that the results can be called to this class
void postResult(String asyncresult){
     //This method will get call as soon as your AsyncTask is complete. asyncresult will be your result.
}