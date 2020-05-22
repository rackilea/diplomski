HashMap<String, List<Double>> map = new HashMap<>();

public static void addInformation(HashMap<String, List<Double>> map) {
    //input should be validated here
    String location = scanner.next();
    Double time = scanner.nextDouble();

    List<Double> timesInMap = map.get(location);
    if (timesInMap != null){
        timesInMap.add(time);
        timesInMap.sort(null);
    }else{
        timesInMap = new ArrayList<Double>();
        timesInMap.add(time);
        map.put(location, timesInMap);
    }
}
public static void printInformation(HashMap<String, List<Double>> map) {
    Set<String> keySet = map.keySet();  
    for (String locationName : keySet) {
        //Use the key to get each value. Repeat for each key.
        System.out.println("Location =" + locationName + " Time =" + 
                map.get(locationName));
    }
}