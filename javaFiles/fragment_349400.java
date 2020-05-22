PrintWriter writer = response.getWriter();
String path = getServletContext().getRealPath("/resources/downloads");
File directory = new File(path);
if(directory.isDirectory()){
   String[] files = directory.list();
   for (String file : files) {
        writer.write(file + "<br/>");
   }
} else writer.write(directory.getAbsolutePath() + "could not be found");