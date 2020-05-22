public ArrayList<Integer> groupSum (int[] values, int sum) {
    ArrayList[] memory = new ArrayList[sum+1];
    memory[0] = new ArrayList<Integer>();
    LexComp<Integer> lc = new LexComp<Integer>();
    int index = 0;
    for(int val : values) {
        for(int i = sum-val; i >= 0 ; i--) {
            if(memory[i] != null) {
                ArrayList<Integer> tmp = (ArrayList<Integer>) memory[i].clone();
                tmp.add(index);
                if(memory[i+val] == null || lc.compare(tmp,(ArrayList<Integer>) memory[i+val]) < 0) {
                    memory[i+val] = tmp;
                }
            }
        }
        index++;
    }
    return memory[sum];
}