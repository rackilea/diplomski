else {
   //errorresponse from restcall to thirdparty-api (just removing prefix here)
   responseString = responseString.replace("sap_error_", "");

   //actually I try to do a somewhat silent idplogin, so this might fit. 
   //you can change this error to the errormsg from thirdparty, too,
   // so its collected in the logs error=-part.
   context.getEvent().error(Errors.IDENTITY_PROVIDER_ERROR);

   //here we're building the actual responseHandler.
   //One might even want to set the status to status from thirdparty. 
   Response challengeResponse = context.form().setError(responseString)
                .createErrorPage(Response.Status.INTERNAL_SERVER_ERROR);

   //And in the end we apply the failureChallenge to the Context  
   context.failureChallenge(AuthenticationFlowError.IDENTITY_PROVIDER_ERROR,
                                     challengeResponse);
}