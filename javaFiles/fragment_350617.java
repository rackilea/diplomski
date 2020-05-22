BufferedReader bufferedReader = 
     new BufferedReader(new InputStreamReader(request1.getInputStream()));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
          System.out.print(line);
        }