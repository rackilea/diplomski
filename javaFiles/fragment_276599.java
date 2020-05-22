@Override
public int compare(Event e1, Event e2) {
   if(sortOrder.equalsIgnoreCase(DESCENDING))
       return compareTo(e2, e1);
   else
       return compareTo(e1, e2);
}

public int compareTo(Event e1, Event e2) {
     Tag t1 = getTag(e1, tagName, tagType); 
     Tag t2 = getTag(e2, tagName, tagType);

     if(t1!=null && t2!=null){
        if(t1.getRank()==null && t2.getRank()!=null)
            return sortOrder.equalsIgnoreCase(DESCENDING) ? 1 : -1;
        else if(t2.getRank()==null && t1.getRank()!=null)
            return sortOrder.equalsIgnoreCase(DESCENDING) ? -1 : 1;          
        else if (t1.getRank() < t2.getRank())
            return -1;
        else if (t1.getRank() > t2.getRank())
            return 1;
        else
            return e1.getId().compareTo(e2.getId()); //If rank null or equal compute rank based on id.
     }
     return 0;
}