protected void writeAjaxResponse(HttpServletRequest req 
                                 ,HttpServletResponse resp,String result){
       resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = null;
        try {
            writer = resp.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.println(result);
        return;

    }