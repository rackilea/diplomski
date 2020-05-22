@Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        if (!HttpServletRequest.class.isInstance(request)) {
            chain.doFilter(request, response);
            return;
        }

        final HttpServletRequest httpServletRequest = HttpServletRequest.class.cast(request);
        final HttpServletResponse httpServletResponse = HttpServletResponse.class.cast(response);

        if (CxfRsHttpListener.TRY_STATIC_RESOURCES) { // else 100% JAXRS
            if (servletMappingIsUnderRestPath(httpServletRequest)) {
                chain.doFilter(request, response);
                return;
            }
            final InputStream staticContent = delegate.findStaticContent(httpServletRequest, welcomeFiles);
            if (staticContent != null) {
                chain.doFilter(request, response);
                return;
            }
        }

        try {
            delegate.doInvoke(
                    new ServletRequestAdapter(httpServletRequest, httpServletResponse, request.getServletContext()),
                    new ServletResponseAdapter(httpServletResponse));
        } catch (final Exception e) {
            throw new ServletException("Error processing webservice request", e);
        }
    }