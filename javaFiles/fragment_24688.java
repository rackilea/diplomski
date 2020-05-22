String responseMessage = response.getMessage();
OutputStreamWriter out = new OutputStreamWriter(httpResponse.getOutputStream());
out.write(responseMessage);
out.close();
httpResponse.setContentType("application/json");
httpResponse.setContentLength(responseMessage.length());
httpResponse.setStatus(response.getResponseCode());