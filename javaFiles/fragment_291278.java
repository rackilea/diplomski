private boolean checkPostedCsrfToken() {
        if (request.getParameterMap().containsKey("csrf")) {
            String csrf = request.getParameter("csrf");
            if (csrf.equals(request.getSession().getAttribute("csrf"))) {
                return true;
            }
        } else if (request.getContentType() != null && request.getContentType().toLowerCase().contains("multipart/form-data")) {
            CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
            MultipartHttpServletRequest multipartRequest = commonsMultipartResolver.resolveMultipart(request);
            if (multipartRequest.getParameterMap().containsKey("csrf")) {
                String csrf = multipartRequest.getParameter("csrf");
                if (csrf.equals(request.getSession().getAttribute("csrf"))) {
                    return true;
                }
            }
        }

        log();
        return false;
    }