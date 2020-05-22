private List<Integer> getMissingNo(String text){
    ArrayList<Integer> missingNo = new ArrayList<Integer>();

    boolean[] usedNos = new boolean[9];
    for(int i=0; i<text.length(); i++){
        usedNos [value70(text.charAt(i))-1] = true;
    }

    for(int i=0; i<9; i++){
        if(!usedNos[i]){
            missingNo.add(i+1);
            System.out.println((i+1) + " is missing");
        }
    }

    return missingNo;
}