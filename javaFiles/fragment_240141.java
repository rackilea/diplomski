Document companyDomain = null;
        try {
            companyDomain = (Document) session.newRequest(DocumentService.CreateDocument)
                    .setInput(NuxeoUtil.getRootDocument(session))
                    .set(NuxeoConstants.NUXEO_TYPE, NuxeoConstants.NUXEO_DOMAIN)
                    .set(NuxeoConstants.NUXEO_NAME, domainName)
                    .set(NuxeoConstants.NUXEO_PROPERTIES,
                            NuxeoConstants.NUXEO_TITLE + domainName + NuxeoConstants.NUXEO_DESCRIPTION + domainName)
                    .execute();
        } catch (Exception e) {
            _log.error(e);
        }