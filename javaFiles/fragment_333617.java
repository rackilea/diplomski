Response response = webTarget.request().
        .header( KeyConstants.REST_URI_APPENDERS, stringBuilder)
        .header( DocusignRESTContants.CONTENT_TYPE, MediaType.APPLICATION_JSON )
        .header( DocusignRESTContants.X_DOCUSIGN_AUTHENTICATION, getDocusignAuthHeader( cu ) )
        .accept( MediaType.APPLICATION_XML )
        .get(Response.class);