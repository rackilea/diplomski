ServletContext servletContext = session.getServletContext();
 String localDir = servletContext.getRealPath("").replace('\\', '/');
 File jnlp = new File(localDir + "something.jnlp");
 FileWriter fw = new FileWriter(jnlp);
BufferedWriter bw = new BufferedWriter(fw);
bw.write(//contents of jnlp file);
 response.sendRedirect(jnlp.getName());