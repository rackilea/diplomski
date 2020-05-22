public void seqList() {
    List<Integer> results= Arrays.asList(1,2,3,5,4,7,8,9,101,102,13,14,15,14,16);

    List<List<Integer>> allSeqList = new ArrayList<>();
    Integer oldVal = null;      
    List<Integer> subList = null;
    Integer lastElement = 1;

    for (Integer value : results) {         
        if (oldVal!=null && value == oldVal + 1) {
            if(subList==null){
                subList= new ArrayList<>();                 
            }
            if(subList.size()==0){
                subList.add(value-1);
            }
            subList.add(value);
        }else{
            if(subList!=null){
                allSeqList.add(subList);
            }

            subList=null;
        }
        if(subList!=null && lastElement==results.size()){
            allSeqList.add(subList);
        }
        lastElement++;
        oldVal=value;
    }

    System.out.println(allSeqList);
}