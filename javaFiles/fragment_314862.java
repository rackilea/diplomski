@RequestMapping( method = RequestMethod.POST, 
    value = DataController.RESOURCE_PATH + "/file", 
    headers = "content-type=application/json" )
public void export( @RequestBody JSONObject json, HttpServletResponse response ) 
    throws IOException {
    String myString = "Hello";
    response.setContentType("text/plain");
    response.setHeader("Content-Disposition","attachment;filename=myFile.txt");
    ServletOutputStream out = response.getOutputStream();
    out.println(myString);
    out.flush();
    out.close();
}