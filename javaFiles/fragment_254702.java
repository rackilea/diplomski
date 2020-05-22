while ((line = br.readLine()) != null) 
        {
            System.out.println(line);
            String compName = "";
            String name = "";
            if(line.contains("CompanyName"))
            {
                String[] splits2 = line.split("=");
                compName = splits2[1]; // second position in the string array.
                if((line = br.readLine()) != null) 
                {
                    String[] splits = line.split("=");
                    name = splits[1];
                }
            }
        }