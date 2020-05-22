protected String determineActionURL(String action, String namespace, String method, HttpServletRequest req, HttpServletResponse res, Map parameters, String scheme, 
            boolean includeContext, boolean encodeResult, boolean forceAddSchemeHostAndPort, boolean escapeAmp)
    {
        String finalAction = findString(action);
        String finalMethod = method == null ? null : findString(method);
        String finalNamespace = determineNamespace(namespace, getStack(), req);
        ActionMapping mapping = new ActionMapping(finalAction, finalNamespace, finalMethod, parameters);
        String uri = actionMapper.getUriFromActionMapping(mapping);
        return UrlHelper.buildUrl(uri, req, res, parameters, scheme, includeContext, encodeResult, forceAddSchemeHostAndPort, escapeAmp);
    }