ProcessBuilder  processBuilder = new ProcessBuilder();
   processBuilder.command("/bin/sh","-c"," . /Home/SomeScript.ksh");
   processBuilder.redirectErrorStream(true);

   processA = processBuilder.start();

   inputStream = processA.getInputStream();
   reader = new BufferedReader(new InputStreamReader(inputStream));
   String line;

   while ((line = reader.readLine()) != null) {
       System.out.println(line);
   }
   System.out.println("Return code is " + processA.exitValue());