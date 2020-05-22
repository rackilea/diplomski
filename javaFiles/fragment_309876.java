//Windows
   String s = "C:\\Test1\\Test2\\Test3\\Test4";
   String[] output = s.split(("/".equals(File.separator))? File.separator : "\\\\" );
   //output: [C:, Test1, Test2, Test3, Test4]

 //Linux:
   String linuxString = "/Test1/Test2/Test3/Test4";
   String[] linuxOutput = linuxString.split(("/".equals(File.separator))? File.separator : "\\\\" );
   //output: [, Test1, Test2, Test3, Test4]