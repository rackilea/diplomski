I am considering following as attributes of your Beacon class:
i)   String hashCode(eg: "ebefd083-70a2-47c8-9837-e7b5634df520")
ii)  String name (eg: "park")
iii) int id (eg: 0)

Below are two cases which I have considered to provide you the solution:
Case A: When you want to sort the arrays of Beacon based on one attribute, lets say its name. So when we have a requirement to sort elements based on one property, then we user Comparable interface.

so your class should be modified as 

public class Beacon implements Comparable {
String hashCode;
String name;
int id;

// getter and setter of above properties
@overriden
public boolean equals(Object obj) {
// it depends on programmer on which property he wants to check equality for, I am //considering hashCode only, you can check for multiple attributes as well.
// you can check for equals proper implementation in internet

 if(obj instance of Beacon) {
  Beacon beacon = (Beacon) obj ;
  if(this.hashCode.equals(beacon.getHashCode())) {
   return true;
  } else { 
   return false;
  }
 } else {
  // some exception
}
}

@overriden 
public int hashCode() {
  return hashCode.length()+name.lenth()+id;
}
}

Now you have some class where you have the array of Beacon as follow:
Beacon[] beaconsList = new Beacon[] {{new Beacon("ebefd083-70a2-47c8-9837-e7b5634df520", "park",0),new Beacon("ebefd083-70a2-47c8-9837-e7b5634df521", "shop",0),new Beacon("ebefd083-70a2-47c8-9837-e7b5634df522", "menu",0),new Beacon("ebefd083-70a2-47c8-9837-e7b5634df523", "weather",0),new Beacon("ebefd083-70a2-47c8-9837-e7b5634df524", "video",0)} ;

List<Beacon> beaconsColl = Arrays.asList(beaconsList);

// This will give you sorted list based on natural ordering of hashCode property
Collections.sort(beaconsColl); 

Now to reverse it use:

// Below will give you list in sorted list in reverse order of hashCode property.
Collections.reverse(beaconsColl);

Case B: When you have a requirement to sort objects based on multiple properties, in such a case we use Comparator, say we have to sort based on id and hashCode, so we have two create two comparators for it. You can google to see the implementation using comparator. 

I guess solution provided in Case A will the one you were looking for. Comments appreciated. Thanks