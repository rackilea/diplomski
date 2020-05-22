public void method() {
    try {
        GetDate dateResponse = client.call();
        if (dateResponse == null) {
            LOG.error("Service returned no dateResponse");
            return optional.absent();
        }
        myDate = dateResponse.getDate();
        if (myDate == null) {
            LOG.error("No myDate");
            return optional.absent();
        }
        returnValue = convertDateToAnotherDate() //actual function
        if (returnValue.isPresent())
            return returnValue;
        LOG.error("Missing required fields");
    } catch (CustomException exception) {
        LOG.error("Custom service failed");
    }
    return optional.absent();
}