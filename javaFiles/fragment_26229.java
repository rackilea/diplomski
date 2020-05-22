while ((line = bufferedReader.readLine()) != null) 
        {                
         if (line.startsWith("#"))
           {
            System.out.println(line);
            String[] parts = line.split("=");   
            System.out.println(Arrays.toString(parts));  
           } 
         }