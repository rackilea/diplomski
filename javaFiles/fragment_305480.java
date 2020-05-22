public TicketManager(){
   try{
    BufferedReader br = new BufferedReader(new FileReader("seatAvailability.txt"));
       for (int i = 0; i < 15; i++)
        String line = br.readLine();    
         seats[i] = line.toCharArray();
       }
   }catch(IOException exception){
       System.out.println("Error processing file: " + exception);
   }
 }