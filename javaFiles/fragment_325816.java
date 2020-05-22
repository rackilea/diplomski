List<String> stations = new ArrayList<String>();  
            //add stations..in the list

    int numStations = stations.size();

    int maxPassengersAtStation = 100;//assgin you number

    for(int sCount=0; sCount<numStations; sCount++){
        int passangersAtStation = (int)(Math.random() * maxPassengersAtStation);
        for(int j=0; j<passangersAtStation; j++){
            int passengerDestination = sCount + (int)(
                       Math.random() * ((numStations - sCount) + 1));
            passengers.add(new Passenger(stations.get(passengerDestination)));
        }
    }