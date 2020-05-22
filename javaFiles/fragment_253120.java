void deleteReservations(String reservationName, BufferedReader input,
      PrintWriter output) throws IOException {
    String date;
    while ((date = input.readLine()) != null) {
      String name = input.readLine();
      String tickets = input.readLine();

      // You can check any part of a reservation here
      // to figure out wether to keep or delete it.
      if (!name.equals(reservationName)) {
        output.println(date);
        output.println(name);
        output.println(tickets);
      }
    }
  }