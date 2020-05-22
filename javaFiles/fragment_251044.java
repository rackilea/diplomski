org.apache.cxf.common.i18n.Message errorMsg = 
        new org.apache.cxf.common.i18n.Message("NO_ROOT_EXC", 
                                           BUNDLE,
                                           message.get(Message.REQUEST_URI),
                                           rawPath);
    LOG.warning(errorMsg.toString());
    Response resp = JAXRSUtils.createResponse(resource, message, errorMsg.toString(), 
            Response.Status.NOT_FOUND.getStatusCode(), false);
    throw new WebApplicationException(resp);