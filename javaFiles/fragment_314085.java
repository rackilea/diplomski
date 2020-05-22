....
            JspWriter   out     = pageContext.getOut();
            HttpSession session = request.getSession();
            String role = (String) session.getAttribute("role");
            if (PARAM_ROLE_TUTOR.equals(role)){
                try {
                    out.println("<c:import url=\"/page/menuForTutor.html\" charEncoding=\"UTF-8\"/>");
                    out.flush();
                    // Evaluate the body if there is one
                    return EVAL_BODY_BUFFERED;
.......

else return SKIP_BODY;