protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        long errMsg;
        if(method.equals("GET")) {
            errMsg = this.getLastModified(req);
            if(errMsg == -1L) {
                this.doGet(req, resp);
            } else {
                long ifModifiedSince = req.getDateHeader("If-Modified-Since");
                if(ifModifiedSince < errMsg) {
                    this.maybeSetLastModified(resp, errMsg);
                    this.doGet(req, resp);
                } else {
                    resp.setStatus(304);
                }
            }
        } else if(method.equals("HEAD")) {
            errMsg = this.getLastModified(req);
            this.maybeSetLastModified(resp, errMsg);
            this.doHead(req, resp);
        } else if(method.equals("POST")) {
            this.doPost(req, resp);
        } else if(method.equals("PUT")) {
            this.doPut(req, resp);
        } else if(method.equals("DELETE")) {
            this.doDelete(req, resp);
        } else if(method.equals("OPTIONS")) {
            this.doOptions(req, resp);
        } else if(method.equals("TRACE")) {
            this.doTrace(req, resp);
        } else {
            String errMsg1 = lStrings.getString("http.method_not_implemented");
            Object[] errArgs = new Object[]{method};
            errMsg1 = MessageFormat.format(errMsg1, errArgs);
            resp.sendError(501, errMsg1);
        }

    }