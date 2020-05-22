@Override
    protected void processMetadataInitialization(HttpServletRequest request) throws ServletException {

                    // In case the hosted SP metadata weren't initialized, let's do it now
                    if (manager.getHostedSPName() == null) {

                        synchronized (MetadataManager.class) {
                              //same code as Base Class
                        }

                    } else {
                            // if known SP is found from federation metadata
                            String requestURL = request.getRequestURL().toString();
                            String subDomain = requestURL.substring(requestURL.indexOf("//") + 2, requestURL.indexOf("."));
                            //set proper SP entityID
                            manager.setHostedSPName("org:example:shagunakarsh:saml:poc:" + subDomain);
                    }
            }