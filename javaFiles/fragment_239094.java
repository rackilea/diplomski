final ServletOutputStream out = res.getOutputStream();
res.setContentType("application/octet-stream");
String file = req.getPathInfo();
if (file == null) {
  out.println("Extra path info was null; should be a resource to view");
  return;
}

// Convert the resource to a URL
URL url = getServletContext().getResource(file);
if (url == null) { 
  out.println("Resource " + file + " not found");
  return;
}

//Serve the file
InputStream in = url.openStream();
byte[] buf = new byte[4 * 1024]; // 4K buffer
int bytesRead;
while ((bytesRead = in.read(buf)) != -1) {
  out.write(buf, 0, bytesRead);
}