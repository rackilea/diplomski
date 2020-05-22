InputStream in = blob.getBinaryStream();
  // Output the blob to the HttpServletResponse

  String codedfilename = "";
  //this code resolves the issue with the encoding of the downloaded filename
  String agent = request.getHeader("USER-AGENT");
  if (null != agent && -1 != agent.indexOf("MSIE"))
  {
    codedfilename = URLEncoder.encode(/*here goes the filename*/, "UTF8");
    response.setContentType("application/x-download");
    response.setHeader("Content-Disposition","attachment;filename=" + codedfilename);
  }
  else if (null != agent && -1 != agent.indexOf("Mozilla"))
  {
    response.setCharacterEncoding("UTF-8");
    //It does not seem to make a difference whether Q or B is chosen
    codedfilename = MimeUtility.encodeText(rset.getString("FILE_NAME"), "UTF8", "B");
    response.setContentType("application/force-download");
    response.addHeader("Content-Disposition", "attachment; filename=\"" + codedfilename + "\"");
  }

  BufferedOutputStream out =
      new BufferedOutputStream(response.getOutputStream());
  byte by[] = new byte[32768];
  int index = in.read(by, 0, 32768);
  while (index != -1) {
      out.write(by, 0, index);
      index = in.read(by, 0, 32768);
  }
  out.flush();