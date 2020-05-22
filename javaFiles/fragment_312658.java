try {
       PrintWriter printWriter = new PrintWriter(new FileWriter("output.txt"));

       for(Passengers[] passengers: Astronauts) {
           for(Passengers passenger: passengers) {
                printWriter.println(passenger);
           }
       }

       printWriter.close();  // no need to flush, since close() does it anyway.

   } catch (IOException e) {
       e.printStackTrace();
   }