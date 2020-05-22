@Override
public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String host = req.getHeader("Host");
        String _protocol = req.getProtocol(); // e.g. HTTP/1.1
        if(host == null || host.isEmpty() || _protocol == null || _protocol.isEmpty()) {
            host = "127.0.0.1:8080";
            HeaderMapRequestWrapper requestWrapper = new HeaderMapRequestWrapper(req, "HTTP/1.1");
            requestWrapper.addHeader("Host", host);
            System.out.println("====================================================");
            System.out.println("Updating Host: " + host);
            System.out.println("====================================================");
            chain.doFilter(requestWrapper, response); 
        } else {
            chain.doFilter(req, response);
        }

    }