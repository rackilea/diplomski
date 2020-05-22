@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    FileManager fileManager = FileManager.getInstance();
    String requestedFileName = req.getParameter("fileName");
    //not really sure what retrieves, I'm assuming it is a Lis<FileEntity>
    //edit this accordingly to your case
    List<FileEntity> files = fileManager.getAllFilesByPath(requestedFileName);
    String json = new ObjectMapper().writeValueAsString(files);
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(json);
}