protected void doGet(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
    //retrieving the parameter by its name
    String fileName = request.getParameter("fileName"); //this will return `data.xls`
    //using the File(parent, child) constructor for File class
    File file = new File(filePath, fileName);
    //verify if the file exists
    if (file.exists()) {
        //move the code to download your file inside here...

    } else {
        //handle a response to do nothing
    }
}