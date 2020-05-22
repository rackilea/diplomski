long longest =  Long.MIN_VALUE;
    Vehicle v = null;
    for (Vehicle vehicle : vehicles){
        long hours = vehicle.getDateTime().hours();
        if (hours > longest){
            longest = hours; 
            v = vehicle;
        }
    }

    if (v!=null) {
        System.out.println("Longest Parked Vehicle is:");
        System.out.println(v);
    }