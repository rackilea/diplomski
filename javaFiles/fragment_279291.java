if(!flights.isEmpty()){
                   Set<MyObject> newflights=new HashSet<MyObject>(); 
                    newflights.addAll(flights); //copy elements to new set
                   arrivals.put(arr, newflights);
                    flights.clear();
                }