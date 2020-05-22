public class CompositePersonComparator implements Comparator<Person> {    
    @Override
    public int compare(Person a, Person b) {
       //1st and foremost - see if they are not of the same status.
       int statusComparison = a.getStatus().compareTo(b.getStatus());
       if (statusComparison!=0) return statusComparison;
       //logical else - same status, sort by name
       return a.getName().compareTo(b.getName());
    }
 }