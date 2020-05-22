package flight;
import java.util.*;

public class Test {

    public static void main(String[] args) {
        List<String> fList = new ArrayList<>();
        fList.add("B");
        fList.add("D");
        Flights f1 = new Flights("A",fList);

        fList = new ArrayList<>();
        fList.add("C");
        fList.add("D");
        fList.add("H");
        Flights f2 = new Flights("B",fList);

        fList = new ArrayList<>();
        fList.add("A");
        Flights f3 = new Flights("D",fList);


        fList = new ArrayList<>();
        fList.add("E");
        Flights f4 = new Flights("C",fList);

        fList = new ArrayList<>();
        fList.add("F");
        fList.add("G");
        Flights f5 = new Flights("E",fList);

        fList = new ArrayList<>();
        fList.add("H");
        Flights f6 = new Flights("G",fList);

        List<Flights> flights = new ArrayList<>();
        flights.add(f1);
        flights.add(f2);
        flights.add(f3);
        flights.add(f4);
        flights.add(f5);
        flights.add(f6);

        String start = "A";
        String end = "H";

        getFlights(flights,start,end,end);

        for(int i=0;i<answerlist.size();i++){   // print here
            String s = answerlist.get(i);
            StringBuilder x = new StringBuilder(); // stringbuilder to reverse the result
            x.append(s);
            x = x.reverse();
            System.out.println(x);
        }
    }
    public static List<String> answerlist = new ArrayList<>();   //list to store result

    private static void getFlights(List<Flights> flights,String start,String destination,String flightResult){
        if (start.equals(destination)){
             flightResult = flightResult+"-"+start;
        }
        List<String> ls = new ArrayList<>();
        for (int i=0;i<flights.size();i++){
            Flights f = flights.get(i);
            if(f.containsDestination(destination)){
                ls.add(flightResult+"-"+f.getStart());
            }
        }
        for (int i=0;i<ls.size();i++){
            String as = ls.get(i);
            String[] s = as.split("-");
            String lastCity = s[s.length-1];
            if (!lastCity.equals(start)){
                getFlights(flights,start,lastCity,as);
            }
            else{
                answerlist.add(as);        //store in a newlist
            }       
        }
    }
}