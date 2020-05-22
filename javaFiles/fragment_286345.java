WebResponse fileResponse = (WebResponse) getRequestCycle().getResponse();
fileResponse.setContentType(mimeType);
fileResponse.setHeader("Content-Disposition", "inline; filename=\"" + fileName + "\"");

fileResponse.write(myByteFile);
getRequestCycle().setResponse(fileResponse);