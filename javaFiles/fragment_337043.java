private static Map<String, ArrayList<Camper>> cabinMap = new  HashMap<String, ArrayList<Camper>>();

public static void userCreatesList(String groupName){
    ArrayList<Camper> cabin = new ArrayList<Camper>();
    cabinMap.put(groupName, cabin);
}