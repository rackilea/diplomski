Dictionary<Time, ArrayList<String> > seatsAvailable = 
    new Dictionary<Time,  ArrayList<String> >();

Time firstBooking = new Time(13,0,0);
Time secondBooking = new Time(15,0,0);

seatsAvailable.put( firstBooking , new ArrayList<String>() );
seatsAvailable.put( secondBooking , new ArrayList<String>() );