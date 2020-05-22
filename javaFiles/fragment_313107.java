gitkit.widget.handler.onProviderSignInIdpClick_ = function(app, component, idp) {
  //null values are removed later in requestGitkitEndpoint
  //not sure if extra paramaters are needed in the Request
  var request = {
    providerId: idp.getProviderId(),
    continueUri: app.getConfig().getIdpCallbackUrl(),
    oauthScope: app.getConfig().getIdpConfigAdditionalScopes(),
    access_type: app.getConfig().getAccessType(),
    approval_prompt: app.getConfig().getApprovalPrompt()
  };
  //the request is then parsed into the executor within component.executeRequest
  component.executeRequest(
    //executor
    goog.bind(app.getApi().createAuthUri, app.getApi()),
    //request
    request,
    //cb
    function(resp) {
      if (!resp || gitkit.api.hasError(resp)) {
        (gitkit.log.error("createAuthUri: " + goog.json.serialize(resp)), component.showInfoBar(gitkit.widget.handler.common.getErrorMessage(gitkit.api.getErrorCode(resp))))
      } else {
        if(resp.providerId === 'google.com'){
          var append = null;
          if (goog.isDefAndNotNull(app.getConfig().getAccessType())) {
            var paramValue = goog.string.urlEncode(app.getConfig().getAccessType());
            append = "&access_type=" + paramValue;
          }
          if (goog.isDefAndNotNull(app.getConfig().getApprovalPrompt())) {
            var paramValue = goog.string.urlEncode(app.getConfig().getApprovalPrompt());
            if(append) append = append.concat("&approval_prompt=" + paramValue);
            else append = "&approval_prompt=" + paramValue
          }
          if(append){
            resp.authUri = resp.authUri.concat(append);
          }
        }
        resp.sessionId && gitkit.storage.setSessionId(resp.sessionId, app.getAppId()),
          gitkit.storage.setRememberAccount(!1, app.getAppId()),
          gitkit.util.goTo(goog.asserts.assert(resp.authUri));
      }
    });
};