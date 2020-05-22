int count= 0;
            FileReader fr = new FileReader("test.txt");
            BufferedReader br = new BufferedReader(fr); 
            String text; 
            while((text= br.readLine()) != null) { 
                   for (int i = 0; i < text.length(); i++) {
                      char c = text.charAt(i);
                      if (c=='*' ) {
                           count++;
                      }
                   }                
                } 

                System.out.println("Count Stars = "+ count);