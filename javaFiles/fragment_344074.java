package sto;

import java.util.ArrayList;

public class PathFinding {
    private static ArrayList<ArrayList<String>> routes = new ArrayList<ArrayList<String>>();
    private static String[] sourceArray      = {"Seattle", "LA",      "LA",    "Florida", "Seattle"};
    private static String[] destinationArray = {"LA",      "Florida", "Maine", "Seattle", "Florida"};

    public static void main(String rgs[])
    {
        find_routes("Seattle", "Maine", new ArrayList<String>());
        for(ArrayList<String> route : routes) {
            for(String node : route) {
                System.out.print(node + ", ");
            }
            System.out.println();
        }
    }

    private static void find_routes(String source, String destination, ArrayList<String> currentRoute) {
        // copy current route and add current node
        ArrayList<String> newRoute = new ArrayList<String>();
        newRoute.addAll(currentRoute);
        newRoute.add(source);
        // recursion anchor: source is destination, so route is finished and can be added to our routes
        if(source.equals(destination)) {
            routes.add(newRoute);
        } else {
            // check all possibilities for other routes
            for(int i = 0; i < sourceArray.length; ++i) {
                if(source.equals(sourceArray[i])) {
                    // if node is already in our route: cycle, i.e. no solution or no optimal solution
                    if(!currentRoute.contains(source)) {
                        find_routes(destinationArray[i], destination, newRoute);
                    }
                }
            }
        }
    }

}