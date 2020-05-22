try (BufferedReader reader = new BufferedReader(new InputStreamReader(sshCmd.inputStream))) {
     String line;
     while ((line = reader.readLine()) != null) {
         System.out.println(line);
     }
 } catch (IOException e) {
     System.out.println(e);
 }