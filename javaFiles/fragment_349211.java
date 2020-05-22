public int solve(ArrayList<Integer> A) {
    Collections.sort(A);
    for(int i=A.size()-1;i>=0; i--){
        if(i<A.size()-1 && A.get(i) == A.get(i+1))continue;
        if(A.get(i) == (A.size()-i-1))
            return 1;
    }
    return -1;
}