protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String username= request.getParameter("username"); // Retrieves <input type="text" name="username">
    Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
    String filename = filePart.getName();
    InputStream filecontent = filePart.getInputStream();
    // ... (do your job here)
}