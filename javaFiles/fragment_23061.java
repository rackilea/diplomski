String s = "function void disableTestOnDevice(SampleBuilder sample,String devices,String[] devTestCode) {\r\n\t\t if(devices == null)\r\n\t\t\t return;\r\n\t";
String s1 = "function void disableTestOnDevice(SampleBuilder sample,String devices,String[] devTestCode) {\n\t\t if(devices == null)\n\t\t\t return;\n\t";
System.out.println(s.replaceAll("\\r|\\n|\\t", ""));
// false
System.out.println(s.equals(s1));
// true
System.out.println(s.replaceAll("\\r|\\n|\\t", "").equals(s1.replaceAll("\\r|\\n|\\t", "")));