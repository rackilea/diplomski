YourObject maxWeight = null; // The temp to determine the max
YourObject current = new YourObject(); // The current object you're storing input into

// Get Data for current from whatever source you're using
if (maxWeight == null || current.getWeight() > maxWeight.getWeight())
    maxWeight = current;

// Do other processing and get the rest of the data
System.out.println(maxWeight.getName() + " has the maximum weight.");