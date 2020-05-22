//these bytes are Cp037 encoded
bytes = txtMsg.getText().getBytes("Cp037");
//you don't seem to be using respStr
String respStr = new String(orginalMsg, "Cp1256");
//you've told this response it is UTF-8, but the bytes are Cp037
response.getOutputStream().write(bytes);