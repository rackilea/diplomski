List<Double> xSecRaw = new ArrayList<>();
// Create a HashSet which allows no duplicates
hashSet = new HashSet<Double>(xSecRaw);

// Assign the HashSet to a new ArrayList
xSec = new ArrayList<Double>(hashSet);

// Ensure correct order, since HashSet doesn't
Collections.sort(xSec);