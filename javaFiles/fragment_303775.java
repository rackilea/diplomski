public class Node {
        public Node parent;
        public final String cityName;
        public double pathCost;
        public int[] roads;

        public Node(String x){
            cityName = x;
        }

        public String myCity(){
            return cityName;
        }
    }

    public class Road {
        public final int ID;
        public final double distance;

        public Road(int id, double cost){
            ID = id;
            distance = cost;
        }
    }

    public Dictionary<String> cities = new Dictionary<String>();

    public void initNodes(){
        int curID = 0;
        Node first, second;
        for(String line : myLines){
            String[] split = line.split("\\s+");
            first = getNode(split[0]);
            second = getNode(split[1]);

            Road r1 = new Road(curID,split[2]);
            first.roads.add(curID);
            second.roads.add(curID);
            curID++;        
        }       
    }

    // Like a singleton...
    public void getNode(string cityName){

        if(!cities.contains(cityName))
        {
            Node newCity = new Node(cityName);
            cities.add(cityName, newCity);
        }
        return cities.get(cityName);    
    }