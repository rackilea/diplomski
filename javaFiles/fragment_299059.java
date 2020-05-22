public void doPost(HttpServletRequest req,HttpServletResponse resp){
      String path = req.getServletContext().getRealPath("/");
      File f = new File (path +"myNewFolder");
      f.mkdir();

}