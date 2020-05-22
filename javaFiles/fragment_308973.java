public classA {

    public static void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        try {
            temp.process(root, resp.getWriter());
        } catch (TemplateException e) {
           throw new IOException("Error while processing Freemarker template", e);
        } 
    }
}