try{
     p = Runtime.getRuntime().exec("free -ms 5");
     BufferedReader br = new BufferedReader(
         new InputStreamReader(p.getInputStream()));
     while ((s = br.readLine()) != null)
         textArea.setText(s);
     p.waitFor();
     System.out.println ("exit: " + p.exitValue());
     p.destroy();
     }
 catch(Exception e)
 {

 }