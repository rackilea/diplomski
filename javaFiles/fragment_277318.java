class ObjectComparator implements Comparator<SomeClass>{

    @Override
    public int compare(SomeClass obj1, SomeClass obj2) {
        // if two objects' ranks are the same 
        if(obj1.rank.equals(obj2.rank)){
            // then compare their names
            return obj1.name.compareTo(obj2.name);
        }
        else{
            return obj1.rank.compareTo(obj2.rank);
        }
    }
}