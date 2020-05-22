AWSCredentials sessionCredentials = new AWSCredentials() {
    @Override
    public String getAWSAccessKeyId() {
        try {
            return getToken(); //getToken() method return a string 
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getAWSSecretKey() {
        return "NOT_USED";
    }
};