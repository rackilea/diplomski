public String verifyResponse(HttpServletRequest httpReq)
{
          ...
//        AuthSuccess authSuccess =
//            (AuthSuccess) verification.getAuthResponse();

//        if (authSuccess.hasExtension(AxMessage.OPENID_NS_AX)) {
//            FetchResponse fetchResp = (FetchResponse) authSuccess
//                .getExtension(AxMessage.OPENID_NS_AX);
//                    
//            List emails = fetchResp.getAttributeValues("email");
//            String email = (String) emails.get(0);
//        }