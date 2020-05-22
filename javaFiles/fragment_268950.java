//add data to a list
List<Data> list = new ArrayList<Data>();
list.add(new Data("Envelope","K205","Green","Paper"));
list.add(new Data("Box","J556","Yellow","Thermocol"));
list.add(new Data("Envelope","L142","White","Plastic"));

//create a comparator to sort by type
Comparator<Data> typeComparator = new Comparator<Data>() {
    @Override
    public int compare(Data o1, Data o2) {
        return o1.getType().compareTo(o2.getType());
    }
};

//sort the list
Collections.sort(list, typeComparator);