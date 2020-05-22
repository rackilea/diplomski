//request in the HttpServletRequest.
Part uploadedFile = request.getPart("parameterName");
InputStream is = uploadedFile.getInputStream();
byte[] fileData = new byte[add a preferred size];
is.read(fileData);
//Save fileData in the database.