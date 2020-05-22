Set<Flight> flights = new HashSet<>();

Scanner sc = new Scanner(System.in);
for(int i = 0; i < 5; ++i){
    Flight f = new Flight();
    f.setDeparture(LocalDate.of(2019, Month.MAY, sc.nextInt()));

    if(flights.add(f)){
        System.out.println("New flight added");
    } else {
        System.out.println("Flight already booked");
    }
}

sc.close();