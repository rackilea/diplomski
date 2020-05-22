@Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("text") == null || req.getParameter("voice") == null) {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            boolean download = false;
            if (req.getParameter("download") != null && req.getParameter("download").equalsIgnoreCase("true")) {
                download = true;
            }

            req.setCharacterEncoding("UTF-8");
            try {
                String queryStr = req.getQueryString();
                String url = baseURL + "/v1/synthesize";
                if (queryStr != null) {
                    url += "?" + queryStr;
                }
                URI uri = new URI(url).normalize();

                Request newReq = Request.Get(uri);
                newReq.addHeader("Accept", "audio/ogg; codecs=opus");

                Executor executor = Executor.newInstance().auth(username, password);
                Response response = executor.execute(newReq);
                if (download)
                {
                    resp.setHeader("content-disposition", "attachment; filename=transcript.ogg");
                }
                ServletOutputStream servletOutputStream = resp.getOutputStream();
                response.returnResponse().getEntity()
                .writeTo(servletOutputStream);
                servletOutputStream.flush();
                servletOutputStream.close();
            } catch (Exception e) {
                // Log something and return an error message
                logger.log(Level.SEVERE, "got error: " + e.getMessage(), e);
                resp.setStatus(HttpStatus.SC_BAD_GATEWAY);
            }
        }
    }