@BodyParser.Of(BodyParser.Raw.class)
public static Result receiveRawInstaData(){
    Map<String, String[]> headers = request().headers();
    RawBuffer jsonRaw = request().body().asRaw();

    if(jsonRaw == null){
        logger.warn("jsonRaw is null. Something is wrong with the payload");
        return badRequest("Expecting serializable raw data");
    }

    String[] xHubSignature = headers.get(InstaSubscriptionUtils.HTTP_HEADER_X_HUB_SIGNATURE);
    if(xHubSignature == null){
        logger.error("Invalid POST. It does not contain {} in its header", InstaSubscriptionUtils.HTTP_HEADER_X_HUB_SIGNATURE);
        return badRequest("You are not Instagram!\n");
    }

    String json;
    byte[] jsonRawBytes;

    jsonRawBytes = jsonRaw.asBytes();
    json = new String(jsonRawBytes, StandardCharsets.UTF_8);

    try {
        String clientSecret = InstaSubscriptionUtils.getClientSecret(1);
        VerificationResult verificationResult = SubscriptionUtil.verifySubscriptionPostRequestSignature
                (clientSecret,jsonRawBytes, xHubSignature[0]);
        if(verificationResult.isSuccess()){
            logger.debug("Signature matches!. Received signature: {}, calculated signature: {}", xHubSignature[0], verificationResult.getCalculatedSignature());
        }else{
            logger.error("Signature doesn't match. Received signature: {}, calculated signature: {}", xHubSignature[0], verificationResult.getCalculatedSignature());
            return badRequest("Signature does not match!\n");
        }
    } catch (InstagramException e) {
        logger.error("Instagram exception.", e);
        return internalServerError("Internal server error. We will attend to this problem ASAP!");
    }

    logger.debug("Received xHubSignature: {}", xHubSignature[0]);
    logger.info("Sucessfully received json data: {}", json);

    return ok("OK!");
}