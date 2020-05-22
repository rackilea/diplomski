public Whatever(ArrayList srcList) {        
    someElements = unmodifiableList(new ArrayList(srcList));

public Whatever(LinkedList srcList) {        
    someElements = unmodifiableList(new LinkedList(srcList));

public Whatever(List srcList) {        
    someElements = unmodifiableList(new ArrayList(srcList)); // ok, no info