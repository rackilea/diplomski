List<Integer> l1 = Arrays.asList(1,2,3,4,5,6);
List<Integer> l2 = Arrays.asList(3,7,8,9,10,11,16);
List<Integer> l3 = new ArrayList<Integer>();//joined List
for ( int i = 0; i < l1.size(); i++ ){
    int index = l2.indexOf(l1.get(i));
    if ( index == -1 ){
        l3.add(l1.get(i));
    }else{
        for ( int j = index; j < l2.size(); j++ ){
            l3.add(l2.get(j));
        }
        break;
    }
}