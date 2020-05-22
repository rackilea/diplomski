BufferedReader br = new BufferedReader(new InputStreamReader(
               is));

int value=0;

         // reads to the end of the stream 
         while((value = br.read()) != -1)
         {
            // converts int to character
            char c = (char)value;

            // prints character
            System.out.println(c);
         }