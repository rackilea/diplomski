ArrayList<Arrivals> arrivals = new ArrayList<Arrivals>();
for (int i = 0; i < flightInfoArray.length; i++) {
     Arrivals new_arrival = new Arrivals(getResources().getIdentifier(
       flightInfoArray[i][2].toLowerCase(), "drawable",
       getPackageName()), "Time:" + flightInfoArray[i][1]
       + " | Flight:  " + ""
       + flightInfoArray[i][2].toUpperCase() + ""
       ....);

     arrivals.add(new_arrival);
}
//now convert the arraylist to array
Arrivals[] arrivals_data = new Arrivals[arrivals.size()];
arrivals_data = arrivals.toArray(arrivals_data);