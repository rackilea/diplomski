{
    SFSErrorData errorData = new SFSErrorData(SFSErrorCode.LOGIN_BAD_PASSWORD);
    errorData.addParameter(email);

    throw new SFSLoginException("Bad password for user: "+ email, errorData);
}