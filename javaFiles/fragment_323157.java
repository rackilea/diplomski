private static ArrayList<Integer> getIndex(List<Double> positiveList, double nvalues) {
    ArrayList<Integer> indices = new ArrayList<Integer>(); //something like this
    for(int i = 0; i < positiveList.size(); i++){
        if(positiveList.get(i)<=nvalues){
            indices.append(i); //add an index to the list
        }
    }
    return indices;
}