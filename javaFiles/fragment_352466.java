HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) resp;

    response.addHeader("Access-Control-Allow-Origin", "*");

    if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
        response.setHeader("Access-Control-Allow-Methods", "POST,GET,DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "content-type,access-control-request-headers,access-control-request-method,accept,origin,authorization,x-requested-with");
        response.setStatus(HttpServletResponse.SC_OK);
    } else {
        chain.doFilter(req, resp);
    }