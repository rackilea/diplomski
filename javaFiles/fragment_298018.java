public void run() {
      System.out.println("lecture COM...");
      for(;;){
          String st = null;
        try {
            st=port.readLine();
        } catch (IOException e) {System.out.println(e.getMessage());}
                   notifyObservers(st); //Pass the data to the observers.
      }
}