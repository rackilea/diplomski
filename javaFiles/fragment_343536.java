URLConnection connection = new URL("http://other.com").openConnection();
connection.setDoOutput(true); // POST
// Copy headers if necessary.

InputStream input1 = request.getInputStream();
OutputStream output1 = connection.getOutputStream();
// Copy request body from input1 to output1.

InputStream input2 = connection.getInputStream();
OutputStream output2 = response.getOutputStream();
// Copy response body from input2 to output2.