Bundle parameters = new Bundle();
parameters.putString("message", "Test Photo");
parameters.putString("attachment", "{\"name\":\"My Test Image\","
+"\"href\":\""+"http://www.google.com"+"\","
+"\"media\":[{\"type\":\"image\",\"src\":\""+"http://www.google.com/logos/mucha10-hp.jpg"+"\",\"href\":\""+"http://www.google.com"+"\"}]"
+"}");
facebookClient.dialog(this, "stream.publish", parameters, this);